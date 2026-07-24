package com.example.climago.data.remote.api

import com.example.climago.data.remote.dto.GeocodingResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApiService {

    @GET("v1/search")
    suspend fun buscarCiudades(
        @Query("name") nombre: String,
        @Query("count") cantidad: Int,
        @Query("language") idioma: String,
        @Query("format") formato: String
    ): GeocodingResponseDto
}