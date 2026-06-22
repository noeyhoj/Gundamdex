package com.example.gundamdexapp.feature.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
data class DetailRoute(
    val id: String,
)
