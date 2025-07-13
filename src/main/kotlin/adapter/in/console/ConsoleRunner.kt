package adapter.`in`.console

import application.port.`in`.TravelRecommendationCommand
import application.port.`in`.TravelRecommendationUseCase
import domain.model.TravelRegionType
import domain.model.TravelStyle

class ConsoleRunner(
    private val useCase: TravelRecommendationUseCase
) {

    fun run() {
        val startDate = prompt("여행 시작 날짜를 입력하세요 (예: 2025-07-10): ")
        val endDate = prompt("여행 종료 날짜를 입력하세요 (예: 2025-07-12): ")
        val regionType = prompt("여행 지역을 선택하세요 (${TravelRegionType.entries.joinToString(" / ") { it.name }}): ")
        val style = prompt("여행 스타일을 선택하세요 (${TravelStyle.entries.joinToString(" / ") { it.name }}): ")

        val command = TravelRecommendationCommand(
            startDate = startDate,
            endDate = endDate,
            regionType = TravelRegionType.valueOf(regionType.uppercase()),
            style = TravelStyle.valueOf(style.uppercase())
        )

        val plan = useCase.recommend(command)

        println("여행 추천 사유: ${plan.reason}")
        plan.destinations.forEach { dest ->
            println("여행지: ${dest.name}")
            println("추천 이유: ${dest.reason}")
            dest.schedules.forEach { sched ->
                println("  ${sched.day}일차: ${sched.activities.joinToString(", ")}")
            }
        }
    }

    private fun prompt(message: String): String {
        print(message)
        return readln()
    }
}
