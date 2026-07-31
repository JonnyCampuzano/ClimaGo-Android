package com.example.climago.domain.model

data class CiudadFavorita(
    val id: Int = 0,
    val nombre: String,
    val pais: String,
    val region: String,
    val latitud: Double,
    val longitud: Double
)