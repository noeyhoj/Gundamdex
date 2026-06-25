package com.example.gundamdexapp.feature.utils

data class SharedTransitionKey(
    val id: String,
    val type: SharedType,
)

enum class SharedType {
    COMPOSABLE,
    IMAGE,
}
