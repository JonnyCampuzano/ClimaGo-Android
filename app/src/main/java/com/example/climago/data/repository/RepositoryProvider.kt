package com.example.climago.data.repository

import com.example.climago.data.remote.api.RetrofitClient
import com.example.climago.data.remote.datasource.ClimaRemoteDataSource
import com.example.climago.domain.repository.ClimaRepository

object RepositoryProvider {

    private val remoteDataSource: ClimaRemoteDataSource by lazy {
        ClimaRemoteDataSource(
            geocodingApiService =
                RetrofitClient.geocodingApiService,

            weatherApiService =
                RetrofitClient.weatherApiService
        )
    }

    val climaRepository: ClimaRepository by lazy {
        ClimaRepositoryImpl(
            remoteDataSource = remoteDataSource
        )
    }
}