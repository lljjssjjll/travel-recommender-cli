package application.service

import application.port.`in`.TravelRecommendationCommand
import application.port.`in`.TravelRecommendationUseCase
import application.port.out.TravelRecommendationClient
import domain.model.TravelPlan
import global.JsonParser

class TravelRecommendationService(
    private val client: TravelRecommendationClient
) : TravelRecommendationUseCase {

    override fun recommend(command: TravelRecommendationCommand): TravelPlan {
        val prompt = buildPrompt(command)

        println(prompt)
        println()

        val recommendation = client.getRecommendation(prompt)

        println(recommendation)

        return JsonParser.fromJson(recommendation)
    }

    private fun buildPrompt(command: TravelRecommendationCommand): String {
        return """
            아래 조건에 맞는 여행지를 추천해줘.
            기간: ${command.startDate} ~ ${command.endDate}
            지역: ${command.regionType.displayName}
            스타일: ${command.style.displayName}
            출력 형식
            {
              "reason": "편안한 휴식을 위한 국내 여행지 추천입니다.",
              "destinations": [
                {
                  "name": "제주도",
                  "reason": "자연 경관과 편의 시설이 잘 어우러진 최고의 휴양지입니다.",
                  "schedules": [
                    {
                      "day": 1,
                      "activities": [
                        "제주 공항 도착 후 호텔 체크인"
                      ]
                    }
                  ]
                }
              ]
            }
        """.trimIndent()
    }
}
