package com.example.climago.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val WEATHER_BASE_URL =
        "https://api.open-meteo.com/"

    private const val GEOCODING_BASE_URL =
        "https://geocoding-api.open-meteo.com/"

    private val weatherRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val geocodingRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(GEOCODING_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val weatherApi: WeatherApiService by lazy {
        weatherRetrofit.create(WeatherApiService::class.java)
    }

    val geocodingApi: GeocodingApiService by lazy {
        geocodingRetrofit.create(GeocodingApiService::class.java)
    }
}