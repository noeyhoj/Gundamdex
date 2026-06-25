package com.example.gundamdexapp.feature.navigation

import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.gundamdexapp.feature.detail.GundamdexDetail
import com.example.gundamdexapp.feature.detail.GundamdexDetailViewModel
import com.example.gundamdexapp.feature.home.GundamdexHome
import com.example.gundamdexapp.feature.home.GundamdexHomeViewModel

@Composable
fun GundamdexNavigation(
    gundamdexHomeViewModel: GundamdexHomeViewModel,
) {
    val navController = rememberNavController()

    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = HomeRoute,
        ) {
            composable<HomeRoute> {
                val uiState by gundamdexHomeViewModel.uiState.collectAsState()

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

                val viewModel: GundamdexDetailViewModel = viewModel(
                    factory = GundamdexDetailViewModel.Factory(
                        id = id,
                    ),
                )
                val uiState by viewModel.uiState.collectAsState()

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
