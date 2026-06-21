package com.example.gundamdexapp.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gundamdexapp.data.mock.GundamMockData
import com.example.gundamdexapp.feature.detail.GundamdexDetail
import com.example.gundamdexapp.feature.home.GundamdexHome
import com.example.gundamdexapp.feature.home.GundamdexHomeStatHolder

@Composable
fun GundamdexNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
    ) {
        composable<HomeRoute> {
            GundamdexHome(
                gundamdexHomeStateHolder = GundamdexHomeStatHolder(
                    gundamData = GundamMockData.mockGundams
                ),
                onCardClick = {
                    navController.navigate(DetailRoute)
                },
            )
        }

        composable<DetailRoute> {
            GundamdexDetail(
                onBackClick = {
                    navController.navigateUp()
                },
            )
        }
    }
}
