package com.example.climago.domain.model

data class Ciudad(
    val id: Long,
    val nombre: String,
    val pais: String,
    val region: String,
    val latitud: Double,
    val longitud: Double
)