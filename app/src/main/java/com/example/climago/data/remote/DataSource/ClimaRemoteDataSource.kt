package com.example.climago.data.remote.DataSource

import com.example.climago.data.remote.api.GeocodingApiService
import com.example.climago.data.remote.api.WeatherApiService
import com.example.climago.data.remote.dto.GeocodingResponseDto
import com.example.climago.data.remote.dto.WeatherResponseDto

class ClimaRemoteDataSource(
    private val geocodingApi: GeocodingApiService,
    private val weatherApi: WeatherApiService
) {
    suspend fun buscarCiudades(
        nombre: String
    ): GeocodingResponseDto {
        return geocodingApi.buscarCiudades(nombre)
    }

    suspend fun obtenerClima(
        latitud: Double,
        longitud: Double
    ): WeatherResponseDto {
        return weatherApi.obtenerClima(
            latitud = latitud,
            longitud = longitud
        )
    }
}