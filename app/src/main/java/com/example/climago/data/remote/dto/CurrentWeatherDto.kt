package com.example.climago.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CurrentWeatherDto(

    val time: String,

    @SerializedName("temperature_2m")
    val temperature: Double,

    @SerializedName("relative_humidity_2m")
    val humidity: Int,

    @SerializedName("apparent_temperature")
    val apparentTemperature: Double,

    val precipitation: Double,

    @SerializedName("weather_code")
    val weatherCode: Int,

    @SerializedName("wind_speed_10m")
    val windSpeed: Double
)