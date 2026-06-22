package com.example.gundamdexapp.feature.detail.uimodel

data class GundamdexDetailUiModel(
    val modelNumber: String = "",
    val name: String = "",
    val series: String = "",
    val imageUrl: String = "",
    val era: String = "",
    val faction: String = "",
    val pilot: String = "",
    val description: String = "",
    val dimensions: DimensionsUiModel = DimensionsUiModel(),
    val technicalSpecifications: TechnicalSpecificationsUiModel = TechnicalSpecificationsUiModel(),
    val armaments: List<ArmamentUiModel> = emptyList(),
)
