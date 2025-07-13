package application.port.`in`

import domain.model.TravelPlan

interface TravelRecommendationUseCase {
    fun recommend(command: TravelRecommendationCommand): TravelPlan
}
