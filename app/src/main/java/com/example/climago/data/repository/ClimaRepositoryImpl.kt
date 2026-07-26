package com.example.climago.data.repository

import com.example.climago.data.remote.api.GeocodingApiService
import com.example.climago.data.remote.api.WeatherApiService
import com.example.climago.data.remote.mapper.toDomain as climaToDomain
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

                    Ciudad(
                        id = ciudadDto.id,
                        nombre = ciudadDto.name,
                        latitud = ciudadDto.latitude,
                        longitud = ciudadDto.longitude,
                        codigoPais = ciudadDto.countryCode.orEmpty(),
                        pais = ciudadDto.country.orEmpty(),
                        region = ciudadDto.admin1.orEmpty(),
                        zonaHoraria = ciudadDto.timezone.orEmpty()
                    )
                }

            Result.success(ciudades)

        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun obtenerClima(
        latitud: Double,
        longitud: Double
    ): Result<Clima> {
        return try {

            val respuesta = weatherApi.obtenerClima(
                latitud = latitud,
                longitud = longitud
            )

            val clima = respuesta.climaToDomain()

            Result.success(clima)

        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}