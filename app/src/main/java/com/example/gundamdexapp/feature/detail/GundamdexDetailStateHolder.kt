package com.example.gundamdexapp.feature.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.gundamdexapp.data.domain.model.GundamInfo
import com.example.gundamdexapp.feature.detail.uimodel.ArmamentUiModel
import com.example.gundamdexapp.feature.detail.uimodel.DimensionsUiModel
import com.example.gundamdexapp.feature.detail.uimodel.GundamdexDetailUiModel
import com.example.gundamdexapp.feature.detail.uimodel.IndicatorColor
import com.example.gundamdexapp.feature.detail.uimodel.TechnicalSpecificationsUiModel

class GundamdexDetailStateHolder(
    id: String,
    gundamData: List<GundamInfo>,
) {
    var uiState by mutableStateOf(GundamdexDetailUiState())

    init {
        uiState = (
            gundamData.firstOrNull { it.id == id }?.let {
                uiState.copy(
                    gundamdexDetailUiModel = GundamdexDetailUiModel(
                        modelNumber = it.modelNumber,
                        name = it.name,
                        series = it.series,
                        imageUrl = it.imageUrl,
                        era = it.era,
                        faction = it.faction,
                        pilot = it.pilot,
                        description = it.description,
                        dimensions = it.dimensions.let { data ->
                            DimensionsUiModel(
                                height = data.height,
                                weight = data.weight,
                            )
                        },
                        technicalSpecifications = it.technicalSpecifications.let { data ->
                            TechnicalSpecificationsUiModel(
                                generatorOutput = data.generatorOutput,
                                armorMaterial = data.armorMaterial,
                                totalTrust = data.totalTrust,
                                sensorRadius = data.sensorRadius,
                                crew = data.crew,
                            )
                        },
                        armaments = it.armaments.let { data ->
                            data.value.map {
                                ArmamentUiModel(
                                    name = it.name,
                                    details = it.details,
                                    indicatorColor = IndicatorColor.dataToIndicatorColor(it.indicatorColor),
                                )
                            }
                        },
                    ),
                )
            } ?: GundamdexDetailUiState(gundamdexDetailUiModel = GundamdexDetailUiModel())
            )
    }
}
