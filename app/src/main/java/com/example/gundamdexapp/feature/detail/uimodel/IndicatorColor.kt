package com.example.gundamdexapp.feature.detail.uimodel

enum class IndicatorColor {
    RED,
    BLUE,
    GRAY,
    ;

    companion object {
        fun dataToIndicatorColor(value: String): IndicatorColor = when (value) {
            "red" -> RED
            "blue" -> BLUE
            "gray" -> GRAY
            else -> throw IllegalArgumentException("잘못된 입력 값을 전달받았습니다.")
        }
    }
}
