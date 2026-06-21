package com.example.gundamdexapp.data.mock

import com.example.gundamdexapp.data.domain.detail.model.Armament
import com.example.gundamdexapp.data.domain.detail.model.Armaments
import com.example.gundamdexapp.data.domain.detail.model.Dimensions
import com.example.gundamdexapp.data.domain.detail.model.GundamInfo
import com.example.gundamdexapp.data.domain.detail.model.IndicatorColor
import com.example.gundamdexapp.data.domain.detail.model.TechnicalSpecifications

object GundamMockData {
    val rx782Info = GundamInfo(
        id = "rx-78-2",
        modelNumber = "RX-78-2",
        name = "건담",
        series = "기동전사 건담",
        imageUrl = "https://gundam-official.com/media/1st_tv_mecha_gundam_front_5f19665050/1st_tv_mecha_gundam_front_5f19665050.png",
        statusBadge = "verified",
        era = "U.C. 0079",
        faction = "지구연방군",
        pilot = "아무로 레이",
        description = "지구연방군이 지온 공국군의 자쿠를 참고해 개발한 백병전용 MS. 사이드 7에서 반출될 예정이었으나, 자쿠의 급습으로 인해 그대로 실전에 배치되었다. 사상 최초로 전함급 위력을 자랑하는 빔 병기를 탑재하여 '연방의 하얀 녀석'이라 불렸다.",
        dimensions = Dimensions(
            height = "18.0m",
            weight = "43.4t"
        ),
        technicalSpecifications = TechnicalSpecifications(
            generatorOutput = "1380 kW",
            armorMaterial = "루나 티타늄 합금",
            totalTrust = "55,500 kg",
            sensorRadius = "5,700 m",
            crew = "Pilot only (Core Block)"
        ),
        armaments = Armaments(
            _value = listOf(
                Armament(
                    name = "60mm 발칸포",
                    details = "x2 (머리 장착)",
                    indicatorColor = IndicatorColor.RED
                ),
                Armament(
                    name = "빔 사벨",
                    details = "x2 (백팩)",
                    indicatorColor = IndicatorColor.BLUE
                ),
                Armament(
                    name = "빔 라이플",
                    details = "휴대용",
                    indicatorColor = IndicatorColor.BLUE
                ),
                Armament(
                    name = "실드",
                    details = "팔 장착 / 휴대용",
                    indicatorColor = IndicatorColor.GRAY
                )
            )
        )
    )
}
