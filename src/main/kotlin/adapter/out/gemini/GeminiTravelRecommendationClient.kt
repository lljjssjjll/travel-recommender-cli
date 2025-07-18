package adapter.out.gemini

import application.port.out.TravelRecommendationClient
import com.google.genai.Client
import com.google.genai.types.GenerateContentConfig

class GeminiTravelRecommendationClient : TravelRecommendationClient {

    init {
        requireNotNull(System.getenv("GEMINI_API_KEY")) { "GEMINI_API_KEY를 설정하세요." }
    }

    private val client = Client()

    override fun getRecommendation(prompt: String): String {
        val response = client.models.generateContent(
            "gemini-2.5-flash",
            prompt,
            GenerateContentConfig.builder().responseMimeType("application/json").build()
        )
        return response.text()
    }
}
