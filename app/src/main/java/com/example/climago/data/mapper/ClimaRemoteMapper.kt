package com.example.climago.data.mapper

import com.example.climago.data.remote.dto.WeatherResponseDto
import com.example.climago.domain.model.Clima
import com.example.climago.obtenerDescripcionClima

fun WeatherResponseDto.toDomain(): Clima {
    return Clima(
        temperatura = current.temperature,
        sensacionTermica = current.apparentTemperature,
        humedad = current.humidity,
        precipitacion = current.precipitation,
        velocidadViento = current.windSpeed,
        codigoClima = current.weatherCode,
        descripcion = obtenerDescripcionClima(
            codigo = current.weatherCode
        )
    )
}