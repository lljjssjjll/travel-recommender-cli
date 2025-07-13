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
        val recommendation = client.getRecommendation(prompt)
        return JsonParser.fromJson(recommendation)
    }

    private fun buildPrompt(command: TravelRecommendationCommand): String {
        return """
            아래 조건에 맞는 여행지를 추천해줘.
            
            조건
            ----- start
            기간: ${command.startDate} ~ ${command.endDate}
            지역: ${command.regionType}
            스타일: ${command.style}
            ----- end
            
            응답 형식은 아래와 같아. json이고, 다른 설명은 필요 없어. json만 주면 돼.
            응답 형식
            ----- start
            {
              "reason": "string",
              "destinations": [
                {
                  "name": "string",
                  "reason": "string",
                  "schedules": [
                    {
                      "day": number,
                      "activities": ["string"]
                    }
                  ]
                }
              ]
            }
            ----- end
        """.trimIndent()
    }
}
