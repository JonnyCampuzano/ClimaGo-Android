package com.example.climago.navigation

sealed class Routes(val route: String) {

    data object Inicio : Routes("inicio")

    data object Busqueda : Routes("busqueda")

    object Detalle : Routes(
        route = "detalle/{nombre}/{pais}/{region}/{latitud}/{longitud}"
    ) {
        fun crearRuta(
            nombre: String,
            pais: String,
            region: String,
            latitud: Double,
            longitud: Double
        ): String {
            return "detalle/$nombre/$pais/$region/$latitud/$longitud"
        }
    }

    data object Favoritos : Routes("favoritos")

    data object Configuracion :
        Routes("configuracion")
}