package domain.travelrecommendation.model

data class TravelPlan(
    val reason: String,
    val destinations: List<Destination>
)
