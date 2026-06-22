package com.example.gundamdexapp.feature.navigation

import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    val gundamdexHomeStateHolder = GundamdexHomeStatHolder(gundamData = gundamData)

    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = HomeRoute,
        ) {
            composable<HomeRoute> {
                val uiState = remember { gundamdexHomeStateHolder.uiState }

                GundamdexHome(
                    gundamdexHomeUiState = uiState,
                    onCardClick = { id ->
                        navController.navigate(DetailRoute(id))
                    },
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@composable,
                )
            }

            composable<DetailRoute> { backStackEntity ->
                val routeData = backStackEntity.toRoute<DetailRoute>()
                val id = routeData.id

                val gundamdexDetailStateHolder = GundamdexDetailStateHolder(
                    id = id,
                    gundamData = gundamData,
                )
                val uiState = remember { gundamdexDetailStateHolder.uiState }

                GundamdexDetail(
                    gundamdexDetailUiState = uiState,
                    onBackClick = {
                        navController.navigateUp()
                    },
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@composable,
                )
            }
        }
    }
}
