package com.example.climago.di

import android.content.Context
import com.example.climago.ClimaGoApplication
import com.example.climago.domain.repository.ClimaRepository

fun Context.obtenerClimaRepository():
        ClimaRepository {
    val application =
        applicationContext as ClimaGoApplication

    return application.container.climaRepository
}