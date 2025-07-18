import adapter.`in`.console.ConsoleRunner
import adapter.out.gemini.GeminiTravelRecommendationClient
import application.service.TravelRecommendationService

fun main() {
    val client = GeminiTravelRecommendationClient()
    val service = TravelRecommendationService(client)
    val cli = ConsoleRunner(service)
    cli.run()
}