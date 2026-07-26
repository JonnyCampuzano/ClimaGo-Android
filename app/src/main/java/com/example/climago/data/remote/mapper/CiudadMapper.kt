package com.example.climago.data.remote.mapper

import com.example.climago.data.remote.dto.CiudadDto
import com.example.climago.domain.model.Ciudad

fun CiudadDto.toDomain(): Ciudad {
    return Ciudad(
        id = id,
        nombre = name,
        latitud = latitude,
        longitud = longitude,
        codigoPais = countryCode.orEmpty(),
        pais = country.orEmpty(),
        region = admin1.orEmpty(),
        zonaHoraria = timezone.orEmpty()
    )
}