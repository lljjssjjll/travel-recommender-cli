package application.port.out

interface TravelRecommendationClient {
    fun getRecommendation(prompt: String): String
}
