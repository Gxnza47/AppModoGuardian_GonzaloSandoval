package com.example.modoguardian_grupomg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.modoguardian_grupomg.navigation.AppIntegrada
import com.example.modoguardian_grupomg.ui.theme.ModoGuardian_GrupoMGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModoGuardian_GrupoMGTheme {
                AppIntegrada()
            }
        }
    }
}