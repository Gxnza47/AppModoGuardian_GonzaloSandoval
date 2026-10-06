package com.example.modoguardian_grupomg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.modoguardian_grupomg.ui.screens.PerfilScreen
import com.example.modoguardian_grupomg.ui.theme.ModoGuardian_GrupoMGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModoGuardian_GrupoMGTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Mostramos la pantalla de perfil con el padding de las barras del sistema
                    PerfilScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}