package com.example.modoguardian_grupomg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.modoguardian_grupomg.navigation.NavigationEvent
import com.example.modoguardian_grupomg.navigation.Screen
import com.example.modoguardian_grupomg.ui.screens.PantallaConfiguracion
import com.example.modoguardian_grupomg.ui.screens.PantallaInicio
import com.example.modoguardian_grupomg.ui.screens.PantallaPerfil
import com.example.modoguardian_grupomg.ui.theme.ModoGuardian_GrupoMGTheme
import com.example.modoguardian_grupomg.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModoGuardian_GrupoMGTheme {

                // ViewModel y NavController
                val viewModel: MainViewModel = viewModel()
                val navController = rememberNavController()

                // Escucha los eventos de navegación emitidos por el ViewModel
                LaunchedEffect(Unit) {
                    viewModel.navigationEvents.collectLatest { event ->
                        when (event) {
                            is NavigationEvent.NavigateTo -> {
                                navController.navigate(event.route.route) {
                                    event.popUpToRoute?.let {
                                        popUpTo(it.route) { inclusive = event.inclusive }
                                    }
                                    launchSingleTop = event.singleTop
                                }
                            }
                            is NavigationEvent.PopBackStack -> navController.popBackStack()
                            is NavigationEvent.NavigateUp -> navController.navigateUp()
                        }
                    }
                }

                // Grafo de navegación: cada ruta lleva a una pantalla
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {
                    composable(Screen.Home.route) { PantallaInicio(viewModel) }
                    composable(Screen.Profile.route) { PantallaPerfil(viewModel) }
                    composable(Screen.Settings.route) { PantallaConfiguracion(viewModel) }
                }
            }
        }
    }
}