import adapter.`in`.console.ConsoleRunner
import adapter.out.openai.OpenAiTravelRecommendationClient
import application.service.TravelRecommendationService

fun main() {
    val client = OpenAiTravelRecommendationClient()
    val service = TravelRecommendationService(client)
    val cli = ConsoleRunner(service)
    cli.run()
}