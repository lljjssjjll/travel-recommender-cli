package adapter.out.openai

import application.port.out.TravelRecommendationClient
import com.theokanning.openai.completion.chat.ChatCompletionRequest
import com.theokanning.openai.completion.chat.ChatMessage
import com.theokanning.openai.service.OpenAiService

class OpenAiTravelRecommendationClient : TravelRecommendationClient {

    private val apiKey = requireNotNull(System.getenv("OPENAI_API_KEY")) { "환경변수 OPENAI_API_KEY가 설정되지 않았습니다." }
    private val model = "gpt-3.5-turbo"
    private val service = OpenAiService(apiKey)

    override fun getRecommendation(prompt: String): String {

        val message = ChatMessage("user", prompt)
        val request = ChatCompletionRequest.builder()
            .messages(listOf(message))
            .model(model)
            .build()
        val response = service.createChatCompletion(request)
        return response.choices.first().message.content.trim()
    }
}
