package com.example.climago.di

import android.content.Context
import com.example.climago.data.remote.datasource.ClimaRemoteDataSource
import com.example.climago.data.repository.ClimaRepositoryImpl
import com.example.climago.domain.repository.ClimaRepository

class AppContainer(
    context: Context
) {

    private val applicationContext =
        context.applicationContext

    private val climaRemoteDataSource:
            ClimaRemoteDataSource by lazy {
        ClimaRemoteDataSource()
    }

    val climaRepository: ClimaRepository by lazy {
        ClimaRepositoryImpl(
            remoteDataSource = climaRemoteDataSource
        )
    }
}