package com.example.climago.data.remote.dto

data class WeatherResponseDto(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val current: CurrentWeatherDto,
    val daily: DailyWeatherDto
)