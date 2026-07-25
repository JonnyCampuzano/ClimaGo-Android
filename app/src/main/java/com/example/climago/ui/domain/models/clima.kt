package com.example.climago.domain.model

data class Clima(
    val temperatura: Double,
    val sensacionTermica: Double,
    val humedad: Int,
    val precipitacion: Double,
    val velocidadViento: Double,
    val codigoClima: Int,
    val descripcion: String
)