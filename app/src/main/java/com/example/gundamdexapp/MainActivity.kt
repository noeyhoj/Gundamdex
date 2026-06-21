package com.example.gundamdexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.gundamdexapp.feature.navigation.GundamdexNavigation
import com.example.gundamdexapp.ui.theme.GundamdexAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GundamdexAppTheme {
                GundamdexNavigation()
            }
        }
    }
}
