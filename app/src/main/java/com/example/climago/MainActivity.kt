package com.example.climago

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.climago.navigation.ClimaNavigation
import com.example.climago.ui.theme.ClimaGoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ClimaGoTheme {
                ClimaNavigation()
            }
        }
    }
}