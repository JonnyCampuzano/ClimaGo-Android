package com.example.climago.data.mapper

import com.example.climago.data.remote.dto.CiudadDto
import com.example.climago.domain.model.Ciudad

fun CiudadDto.toDomain(): Ciudad {
    return Ciudad(
        id = id,
        nombre = name,
        pais = country ?: "País no disponible",
        region = admin1 ?: "Región no disponible",
        latitud = latitude,
        longitud = longitude
    )
}