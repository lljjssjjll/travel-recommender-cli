package domain.model

data class Destination(
    val name: String,
    val reason: String,
    val schedules: List<Schedule>
)
