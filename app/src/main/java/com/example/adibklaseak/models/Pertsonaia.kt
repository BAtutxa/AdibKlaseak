package com.example.adibklaseak.models

import kotlinx.serialization.Serializable

@Serializable
data class Pertsonaia(
    val name : String,
    val ki : String,
    val maxKi : String,
    val irudia : String
)
