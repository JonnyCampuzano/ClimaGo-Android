package com.example.climago
fun obtenerDescripcionClima(codigo: Int): String {
    return when (codigo) {
        0 -> "Cielo despejado"
        1 -> "Principalmente despejado"
        2 -> "Parcialmente nublado"
        3 -> "Nublado"
        45, 48 -> "Neblina"
        51, 53, 55 -> "Llovizna"
        61, 63, 65 -> "Lluvia"
        71, 73, 75 -> "Nieve"
        80, 81, 82 -> "Chubascos"
        95 -> "Tormenta"
        96, 99 -> "Tormenta con granizo"
        else -> "Estado no disponible"
    }
}