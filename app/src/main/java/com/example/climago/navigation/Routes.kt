package com.example.climago.navigation

sealed class Routes(val route: String) {

    data object Inicio : Routes("inicio")

    data object Busqueda : Routes("busqueda")

    data object Detalle : Routes("detalle")

    data object Favoritos : Routes("favoritos")

    data object Configuracion : Routes("configuracion")
}