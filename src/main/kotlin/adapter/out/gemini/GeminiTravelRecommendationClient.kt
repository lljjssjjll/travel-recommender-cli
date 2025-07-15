package adapter.out.gemini

import application.port.out.TravelRecommendationClient
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import com.google.ai.client.generativeai.type.text

class GeminiTravelRecommendationClient : TravelRecommendationClient {

    private val apiKey = requireNotNull(System.getenv("GEMINI_API_KEY")) { "GEMINI_API_KEY가 필요합니다." }
    private val model = GenerativeModel(modelName = "gemini-pro", apiKey = apiKey)

    override fun getRecommendation(prompt: String): String {
        val request = content { text(prompt) }
        val response = model.generateContent(request)
        return response.text.trim()
    }
}
