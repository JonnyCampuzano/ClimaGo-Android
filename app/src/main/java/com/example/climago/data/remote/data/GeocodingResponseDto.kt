package com.example.climago.data.remote.dto

data class GeocodingResponseDto(
    val results: List<GeocodingResultDto>? = null
)

data class GeocodingResultDto(
    val id: Long? = null,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String? = null,
    val admin1: String? = null
)