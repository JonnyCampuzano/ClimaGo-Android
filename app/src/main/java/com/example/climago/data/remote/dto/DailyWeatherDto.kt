package com.example.climago.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DailyWeatherDto(

    val time: List<String>,

    @SerializedName("weather_code")
    val weatherCodes: List<Int>,

    @SerializedName("temperature_2m_max")
    val maximumTemperatures: List<Double>,

    @SerializedName("temperature_2m_min")
    val minimumTemperatures: List<Double>
)