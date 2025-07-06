package application.port.`in`

import domain.model.TravelRegionType
import domain.model.TravelStyle

data class TravelRecommendationCommand(
    val startDate: String,
    val endDate: String,
    val regionType: TravelRegionType,
    val style: TravelStyle
)
