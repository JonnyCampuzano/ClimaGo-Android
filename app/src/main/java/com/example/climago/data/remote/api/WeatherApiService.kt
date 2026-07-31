package com.example.climago.data.remote.api

import com.example.climago.data.remote.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("v1/forecast")
    suspend fun obtenerClima(
        @Query("latitude")
        latitud: Double,

        @Query("longitude")
        longitud: Double,

        @Query("current")
        current: String =
            "temperature_2m,relative_humidity_2m,apparent_temperature," +
                    "precipitation,weather_code,wind_speed_10m",

        @Query("daily")
        daily: String =
            "weather_code,temperature_2m_max,temperature_2m_min," +
                    "precipitation_sum",

        @Query("timezone")
        zonaHoraria: String = "auto"
    ): WeatherResponseDto
}