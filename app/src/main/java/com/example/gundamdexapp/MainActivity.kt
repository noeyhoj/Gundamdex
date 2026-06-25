package com.example.gundamdexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.gundamdexapp.feature.home.GundamdexHomeViewModel
import com.example.gundamdexapp.feature.navigation.GundamdexNavigation
import com.example.gundamdexapp.ui.theme.GundamdexAppTheme
import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val application = application as GundamApplication
        val gundamRepository = application.appContainer.gundamRepository

        val gundamdexHomeViewModel by viewModels<GundamdexHomeViewModel> { GundamdexHomeViewModel.Factory }

        setContent {
            GundamdexAppTheme {
                GundamdexNavigation(
                    gundamdexHomeViewModel = gundamdexHomeViewModel,
                )
            }
        }
    }
}
