package application.port.out

import domain.model.TravelPlan

interface TravelRecommendationClient {
    fun getRecommendation(prompt: String): TravelPlan
}