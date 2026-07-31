package com.example.climago.data.mapper

import com.example.climago.data.local.entity.CiudadFavoritaEntity
import com.example.climago.domain.model.Ciudad
import com.example.climago.domain.model.CiudadFavorita

fun CiudadFavoritaEntity.toDomain(): CiudadFavorita {
    return CiudadFavorita(
        id = id,
        nombre = nombre,
        pais = pais,
        region = region,
        latitud = latitud,
        longitud = longitud
    )
}

fun CiudadFavorita.toEntity(): CiudadFavoritaEntity {
    return CiudadFavoritaEntity(
        id = id,
        nombre = nombre,
        pais = pais,
        region = region,
        latitud = latitud,
        longitud = longitud
    )
}

fun Ciudad.toFavorita(): CiudadFavorita {
    return CiudadFavorita(
        nombre = nombre,
        pais = pais,
        region = region,
        latitud = latitud,
        longitud = longitud
    )
}