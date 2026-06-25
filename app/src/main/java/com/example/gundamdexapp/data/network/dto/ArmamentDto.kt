package com.example.gundamdexapp.data.network.dto

import com.example.gundamdexapp.domain.model.Armament
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArmamentDto(
    @SerialName("gundam_id")
    val gundamId: String,
    val name: String,
    val details: String? = null,
    @SerialName("indicator_color")
    val indicatorColor: String,
) {
    fun toDomain(): Armament = Armament(
        name = this.name,
        details = this.details ?: "",
        indicatorColor = this.indicatorColor,
    )
}
