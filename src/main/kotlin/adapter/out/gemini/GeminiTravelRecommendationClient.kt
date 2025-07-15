package adapter.out.gemini

import application.port.out.TravelRecommendationClient
import com.google.genai.GenerativeModel
import com.google.genai.type.content
import com.google.genai.type.text

class GeminiTravelRecommendationClient : TravelRecommendationClient {

    private val apiKey = requireNotNull(System.getenv("GEMINI_API_KEY")) { "GEMINI_API_KEY가 필요합니다." }
    private val model = GenerativeModel(modelName = "gemini-pro", apiKey = apiKey)

    override fun getRecommendation(prompt: String): String {
        val request = content { text(prompt) }
        val response = model.generateContent(request)
        return response.text.trim()
    }
}
