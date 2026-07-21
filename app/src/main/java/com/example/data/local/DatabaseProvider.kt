package com.example.climago.data.local

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    @Volatile
    private var database: ClimaDatabase? = null

    fun obtenerDatabase(context: Context): ClimaDatabase {
        return database ?: synchronized(this) {
            val instancia = Room.databaseBuilder(
                context.applicationContext,
                ClimaDatabase::class.java,
                "climago_database"
            ).build()

            database = instancia
            instancia
        }
    }
}