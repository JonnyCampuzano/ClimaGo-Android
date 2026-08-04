package com.example.climago.navigation
import android.net.Uri
import com.example.climago.ui.screens.busqueda.BusquedaScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.climago.ui.screens.busqueda.BusquedaScreen
import com.example.climago.ui.screens.configuracion.ConfiguracionScreen
import com.example.climago.ui.screens.detalle.DetalleScreen
import com.example.climago.ui.screens.favoritos.FavoritosScreen
import com.example.climago.ui.screens.inicio.InicioScreen

@Composable
fun ClimaNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Inicio.route
    ) {

        /*
        |--------------------------------------------------------------
        | PANTALLA DE INICIO
        |--------------------------------------------------------------
        */
        composable(Routes.Inicio.route) {

            InicioScreen(
                onBuscarClick = {
                    navController.navigate(Routes.Busqueda.route)
                },
                onFavoritosClick = {
                    navController.navigate(Routes.Favoritos.route)
                },
                onConfiguracionClick = {
                    navController.navigate(Routes.Configuracion.route)
                }
            )
        }

        /*
        |--------------------------------------------------------------
        | PANTALLA DE BÚSQUEDA
        |--------------------------------------------------------------
        */
        composable(Routes.Busqueda.route) {

            BusquedaScreen(
                onCiudadClick = { ciudad ->

                    val nombreSeguro = Uri.encode(ciudad.nombre)

                    val paisSeguro = Uri.encode(
                        ciudad.pais.ifBlank { "Sin país" }
                    )

                    val regionSegura = Uri.encode(
                        ciudad.region.ifBlank { "Sin región" }
                    )

                    val rutaDetalle = Routes.Detalle.crearRuta(
                        nombre = nombreSeguro,
                        pais = paisSeguro,
                        region = regionSegura,
                        latitud = ciudad.latitud,
                        longitud = ciudad.longitud
                    )

                    navController.navigate(rutaDetalle)
                }
            )
        }

        /*
        |--------------------------------------------------------------
        | PANTALLA DE DETALLE
        |--------------------------------------------------------------
        */
        composable(
            route = Routes.Detalle.route,
            arguments = listOf(
                navArgument("nombre") {
                    type = NavType.StringType
                },
                navArgument("latitud") {
                    type = NavType.StringType
                },
                navArgument("longitud") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val nombreCodificado = backStackEntry.arguments
                ?.getString("nombre")
                .orEmpty()

            val nombre = Uri.decode(nombreCodificado)

            val latitud = backStackEntry.arguments
                ?.getString("latitud")
                ?.toDoubleOrNull()
                ?: 0.0

            val longitud = backStackEntry.arguments
                ?.getString("longitud")
                ?.toDoubleOrNull()
                ?: 0.0

            DetalleScreen(
                nombreCiudad = nombre,
                pais = "",
                region = "",
                latitud = latitud,
                longitud = longitud
            )
        }

        /*
        |--------------------------------------------------------------
        | PANTALLA DE FAVORITOS
        |--------------------------------------------------------------
        */
        composable(Routes.Favoritos.route) {

            FavoritosScreen(
                onCiudadClick = { ciudad ->

                    val nombreSeguro = Uri.encode(ciudad.nombre)

                    navController.navigate(
                        Routes.Detalle.crearRuta(
                            nombre = Uri.encode(ciudad.nombre),
                            pais = Uri.encode(
                                ciudad.pais.ifBlank { "Sin país" }
                            ),
                            region = Uri.encode(
                                ciudad.region.ifBlank { "Sin región" }
                            ),
                            latitud = ciudad.latitud,
                            longitud = ciudad.longitud
                        )
                    )
                }
            )

        }

        /*
        |--------------------------------------------------------------
        | PANTALLA DE CONFIGURACIÓN
        |--------------------------------------------------------------
        */
        composable(Routes.Configuracion.route) {
            ConfiguracionScreen()
        }
    }
}