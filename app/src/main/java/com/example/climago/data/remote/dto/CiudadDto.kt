package com.example.climago.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CiudadDto(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double,

    @SerializedName("country_code")
    val countryCode: String?,

    val country: String?,
    val admin1: String?,
    val timezone: String?
)