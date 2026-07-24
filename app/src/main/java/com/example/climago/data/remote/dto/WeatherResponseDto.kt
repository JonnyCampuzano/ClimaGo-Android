package com.example.climago.data.remote.dto

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(

    val latitude: Double,

    val longitude: Double,

    val timezone: String,

    val current: CurrentWeatherDto?,

    val daily: DailyWeatherDto?
)

data class CurrentWeatherDto(

    val time: String?,

    @SerializedName("temperature_2m")
    val temperatura: Double?,

    @SerializedName("relative_humidity_2m")
    val humedad: Int?,

    @SerializedName("weather_code")
    val codigoClima: Int?,

    @SerializedName("wind_speed_10m")
    val velocidadViento: Double?
)

data class DailyWeatherDto(

    val time: List<String>?,

    @SerializedName("temperature_2m_max")
    val temperaturaMaxima: List<Double>?,

    @SerializedName("temperature_2m_min")
    val temperaturaMinima: List<Double>?,

    @SerializedName("weather_code")
    val codigoClima: List<Int>?
)