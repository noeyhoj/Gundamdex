package com.example.gundamdexapp.feature.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.gundamdexapp.data.domain.model.GundamInfo

class GundamdexHomeStatHolder(
    gundamData: List<GundamInfo>,
) {
    var uiState by mutableStateOf(GundamdexHomeUiState())

    init {
        uiState = uiState.copy(
            gundamInfoList = gundamData.map {
                GundamdexHomeUiModel(
                    id = it.id,
                    modelNumber = it.modelNumber,
                    name = it.name,
                    series = it.series,
                    imageUrl = it.imageUrl
                )
            }
        )
    }
}
