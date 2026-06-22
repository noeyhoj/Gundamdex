package com.example.gundamdexapp.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.gundamdexapp.data.mock.GundamMockData
import com.example.gundamdexapp.feature.detail.GundamdexDetail
import com.example.gundamdexapp.feature.detail.GundamdexDetailStateHolder
import com.example.gundamdexapp.feature.home.GundamdexHome
import com.example.gundamdexapp.feature.home.GundamdexHomeStatHolder

@Composable
fun GundamdexNavigation() {
    val navController = rememberNavController()
    val gundamData = GundamMockData.mockGundams

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
    ) {
        composable<HomeRoute> {
            val gundamdexHomeStateHolder = GundamdexHomeStatHolder(gundamData = gundamData)

            GundamdexHome(
                gundamdexHomeUiState = gundamdexHomeStateHolder.uiState,
                onCardClick = { id ->
                    navController.navigate(DetailRoute(id))
                },
            )
        }

        composable<DetailRoute> { backStackEntity ->
            val routeData = backStackEntity.toRoute<DetailRoute>()
            val id = routeData.id

            val gundamdexDetailStateHolder = GundamdexDetailStateHolder(
                id = id,
                gundamData = gundamData,
            )

            GundamdexDetail(
                gundamdexDetailUiState = gundamdexDetailStateHolder.uiState,
                onBackClick = {
                    navController.navigateUp()
                },
            )
        }
    }
}
