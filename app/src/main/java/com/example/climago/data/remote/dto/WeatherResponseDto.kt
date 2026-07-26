package com.example.climago.data.remote.dto

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(

    val latitude: Double,

    val longitude: Double,

    val timezone: String,

    @SerializedName("current")
    val current: CurrentWeatherDto,

    @SerializedName("daily")
    val daily: DailyWeatherDto
)