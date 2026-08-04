package com.example.climago

import android.app.Application
import com.example.climago.di.AppContainer

class ClimaGoApplication : Application() {

    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()

        container = AppContainer(
            context = this
        )
    }
}