package adapter.out.openai

import application.port.out.TravelRecommendationClient
import com.theokanning.openai.service.OpenAiService
import com.theokanning.openai.completion.chat.ChatCompletionRequest
import com.theokanning.openai.completion.chat.ChatMessage

class OpenAiTravelRecommendationClient(
    apiKey: String,
    private val model: String = "gpt-3.5-turbo"
) : TravelRecommendationClient {

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
