package com.example.climago.data.repository

import com.example.climago.data.remote.api.RetrofitClient
import com.example.climago.domain.repository.ClimaRepository

object RepositoryProvider {

    val climaRepository: ClimaRepository by lazy {
        ClimaRepositoryImpl(
            geocodingApi = RetrofitClient.geocodingApi,
            weatherApi = RetrofitClient.weatherApi
        )
    }
}