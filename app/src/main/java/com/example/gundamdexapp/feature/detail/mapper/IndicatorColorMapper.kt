package com.example.gundamdexapp.feature.detail.mapper

import androidx.compose.ui.graphics.Color
import com.example.gundamdexapp.feature.detail.uimodel.IndicatorColor
import com.example.gundamdexapp.feature.detail.uimodel.IndicatorColor.BLUE
import com.example.gundamdexapp.feature.detail.uimodel.IndicatorColor.GREY
import com.example.gundamdexapp.feature.detail.uimodel.IndicatorColor.RED

fun IndicatorColor.toColor(): Color = when (this) {
    RED -> Color.Red
    BLUE -> Color.Blue
    GREY -> Color.Gray
}
