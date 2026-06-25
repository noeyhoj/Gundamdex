package com.example.gundamdexapp.data.network.dto

import com.example.gundamdexapp.domain.model.Armaments
import com.example.gundamdexapp.domain.model.Dimensions
import com.example.gundamdexapp.domain.model.GundamInfo
import com.example.gundamdexapp.domain.model.TechnicalSpecifications
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GundamDto(
    val id: String,
    @SerialName("model_number")
    val modelNumber: String? = null,
    val name: String,
    val series: String,
    @SerialName("image_url")
    val imageUrl: String? = null,
    val era: String,
    val faction: String,
    val pilot: String? = null,
    val description: String,
    @SerialName("dim_weight")
    val weight: String? = null,
    @SerialName("dim_height")
    val height: String? = null,
    @SerialName("tech_generator_output")
    val generatorOutput: String? = null,
    @SerialName("tech_armor_material")
    val armorMaterial: String? = null,
    @SerialName("tech_total_trust")
    val totalTrust: String? = null,
    @SerialName("tech_sensor_radius")
    val sensorRadius: String? = null,
    @SerialName("tech_crew")
    val crew: String? = null,
    val armaments: List<ArmamentDto> = emptyList(),
) {
    fun toDomain(): GundamInfo = GundamInfo(
        id = this.id,
        modelNumber = this.modelNumber ?: MISSING_TEXT,
        name = this.name,
        series = this.series,
        imageUrl = this.imageUrl ?: MISSING_URL,
        era = this.era,
        faction = this.faction,
        pilot = this.pilot ?: MISSING_TEXT,
        description = this.description,
        dimensions = Dimensions(
            height = this.height ?: MISSING_TEXT,
            weight = this.weight ?: MISSING_TEXT,
        ),
        technicalSpecifications = TechnicalSpecifications(
            generatorOutput = this.generatorOutput ?: MISSING_TEXT,
            armorMaterial = this.armorMaterial ?: MISSING_TEXT,
            totalTrust = this.totalTrust ?: MISSING_TEXT,
            sensorRadius = this.sensorRadius ?: MISSING_TEXT,
            crew = this.crew ?: MISSING_TEXT,
        ),
        armaments = Armaments(this.armaments.map { it.toDomain() }),
    )

    companion object {
        const val MISSING_TEXT = "[  ?  ]"
        const val MISSING_URL =
            "https://imgfiles-cdn.plaync.com/file/BladeNSoul/download/20190802085052-S4BOYrvsgcmithzSaShj0-v4"
    }
}
