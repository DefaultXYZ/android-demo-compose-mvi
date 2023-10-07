package com.defaultxyz.feature.b

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.defaultxyz.ui.routing.ScreenRoute.FeatureB

fun NavGraphBuilder.featureBGraph(navController: NavController) {
    navigation(route = FeatureB.route, startDestination = FeatureB.ScreenB1.route) {
        composable(FeatureB.ScreenB1.route) {
            FeatureBScreen()
        }
    }
}
