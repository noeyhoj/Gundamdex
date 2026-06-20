package com.example.gundamdexapp.feature.detail.model

import androidx.compose.ui.graphics.Color
import com.example.gundamdexapp.feature.detail.model.IndicatorColor.BLUE
import com.example.gundamdexapp.feature.detail.model.IndicatorColor.GRAY
import com.example.gundamdexapp.feature.detail.model.IndicatorColor.RED

enum class IndicatorColor {
    RED, BLUE, GRAY;
}

fun IndicatorColor.toColor(): Color {
    return when(this) {
        RED -> Color.Red
        BLUE -> Color.Blue
        GRAY -> Color.Gray
    }
}
