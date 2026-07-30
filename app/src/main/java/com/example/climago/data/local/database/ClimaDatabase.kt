package com.example.climago.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.climago.data.local.dao.CiudadFavoritaDao
import com.example.climago.data.local.entity.CiudadFavoritaEntity

@Database(
    entities = [CiudadFavoritaEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ClimaDatabase : RoomDatabase() {

    abstract fun ciudadFavoritaDao(): CiudadFavoritaDao
}