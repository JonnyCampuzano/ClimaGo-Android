package com.example.climago.domain.repository

import com.example.climago.domain.model.Ciudad
import com.example.climago.domain.model.Clima

interface ClimaRepository {

    suspend fun buscarCiudades(
        nombre: String
    ): Result<List<Ciudad>>

    suspend fun obtenerClima(
        latitud: Double,
        longitud: Double
    ): Result<Clima>
}