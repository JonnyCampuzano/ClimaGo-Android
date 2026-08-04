package com.example.climago.data.remote.datasource

import com.example.climago.data.remote.api.GeocodingApiService
import com.example.climago.data.remote.api.RetrofitClient
import com.example.climago.data.remote.api.WeatherApiService
import com.example.climago.data.remote.dto.GeocodingResponseDto
import com.example.climago.data.remote.dto.WeatherResponseDto

class ClimaRemoteDataSource(
    private val geocodingApiService: GeocodingApiService =
        RetrofitClient.geocodingApiService,

    private val weatherApiService: WeatherApiService =
        RetrofitClient.weatherApiService
) {

    suspend fun buscarCiudades(
        nombre: String
    ): GeocodingResponseDto {
        return geocodingApiService.buscarCiudades(
            nombre = nombre
        )
    }

    suspend fun obtenerClima(
        latitud: Double,
        longitud: Double
    ): WeatherResponseDto {
        return weatherApiService.obtenerClima(
            latitud = latitud,
            longitud = longitud
        )
    }
}