package com.example.gundamdexapp.domain.model

data class GundamInfo(
    val id: String = "",
    val modelNumber: String = "",
    val name: String = "",
    val series: String = "",
    val imageUrl: String = "",
    val era: String = "",
    val faction: String = "",
    val pilot: String = "",
    val description: String = "",
    val dimensions: Dimensions = Dimensions(),
    val technicalSpecifications: TechnicalSpecifications = TechnicalSpecifications(),
    val armaments: Armaments = Armaments(),
)
