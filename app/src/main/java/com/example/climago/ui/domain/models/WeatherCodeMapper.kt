package com.example.climago.ui.domain.models

object WeatherCodeMapper {

    fun obtenerDescripcion(codigo: Int): String {
        return when (codigo) {
            0 -> "Cielo despejado"
            1 -> "Principalmente despejado"
            2 -> "Parcialmente nublado"
            3 -> "Nublado"

            45, 48 -> "Niebla"

            51, 53, 55 -> "Llovizna"
            56, 57 -> "Llovizna helada"

            61, 63, 65 -> "Lluvia"
            66, 67 -> "Lluvia helada"

            71, 73, 75 -> "Nieve"
            77 -> "Granizo de nieve"

            80, 81, 82 -> "Chubascos"
            85, 86 -> "Chubascos de nieve"

            95 -> "Tormenta"
            96, 99 -> "Tormenta con granizo"

            else -> "Clima desconocido"
        }
    }
}

