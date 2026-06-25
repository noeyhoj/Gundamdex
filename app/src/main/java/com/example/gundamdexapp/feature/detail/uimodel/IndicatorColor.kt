package com.example.gundamdexapp.feature.detail.uimodel

enum class IndicatorColor {
    RED,
    BLUE,
    GREY,
    ;

    companion object {
        fun dataToIndicatorColor(value: String): IndicatorColor = when (value) {
            "red" -> RED
            "blue" -> BLUE
            "grey" -> GREY
            else -> throw IllegalArgumentException("잘못된 indicator color 입력 값을 전달받았습니다.")
        }
    }
}
