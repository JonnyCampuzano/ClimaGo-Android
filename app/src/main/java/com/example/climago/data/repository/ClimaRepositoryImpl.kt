package com.example.climago.data.repository

import com.example.climago.data.mapper.toDomain
import com.example.climago.data.remote.api.GeocodingApiService
import com.example.climago.data.remote.api.WeatherApiService
import com.example.climago.domain.model.Ciudad
import com.example.climago.domain.model.Clima
import com.example.climago.domain.repository.ClimaRepository

class ClimaRepositoryImpl(
    private val geocodingApi: GeocodingApiService,
    private val weatherApi: WeatherApiService
) : ClimaRepository {

    override suspend fun buscarCiudades(
        nombre: String
    ): Result<List<Ciudad>> {
        return try {

            val respuesta = geocodingApi.buscarCiudades(nombre)

            val ciudades: List<Ciudad> = respuesta.results
                .orEmpty()
                .map { ciudadDto ->
                    ciudadDto.toDomain()
                }

            Result.success(ciudades)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun obtenerClima(
        latitud: Double,
        longitud: Double
    ): Result<Clima> {
        return try {

            val respuesta = weatherApi.obtenerClima(
                latitud,
                longitud
            )

            val clima = respuesta.toDomain()

            Result.success(clima)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}