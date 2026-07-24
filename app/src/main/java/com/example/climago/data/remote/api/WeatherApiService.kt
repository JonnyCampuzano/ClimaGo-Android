package com.example.climago.data.remote.api

import com.example.climago.data.remote.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("v1/forecast")
    suspend fun obtenerClima(
        @Query("latitude") latitud: Double,
        @Query("longitude") longitud: Double,
        @Query("current") variablesActuales: String,
        @Query("daily") variablesDiarias: String,
        @Query("timezone") zonaHoraria: String
    ): WeatherResponseDto
}