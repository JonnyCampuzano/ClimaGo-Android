package com.example.climago.data.remote.mapper

import com.example.climago.data.remote.dto.WeatherResponseDto
import com.example.climago.domain.model.Clima

fun WeatherResponseDto.toDomain(): Clima {
    return Clima(
        temperatura = current.temperature,
        sensacionTermica = current.apparentTemperature,
        humedad = current.humidity,
        precipitacion = current.precipitation,
        codigoClima = current.weatherCode,
        velocidadViento = current.windSpeed
    )
}