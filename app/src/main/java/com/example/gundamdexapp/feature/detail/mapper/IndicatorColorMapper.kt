package com.example.gundamdexapp.feature.detail.mapper

import androidx.compose.ui.graphics.Color
import com.example.gundamdexapp.data.domain.model.IndicatorColor
import com.example.gundamdexapp.data.domain.model.IndicatorColor.BLUE
import com.example.gundamdexapp.data.domain.model.IndicatorColor.GRAY
import com.example.gundamdexapp.data.domain.model.IndicatorColor.RED

fun IndicatorColor.toColor(): Color = when (this) {
    RED -> Color.Red
    BLUE -> Color.Blue
    GRAY -> Color.Gray
}
