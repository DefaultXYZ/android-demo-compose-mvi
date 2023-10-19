package com.defaultxyz.feature.b

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.defaultxyz.ui.routing.FeatureRoute.FeatureB
import com.defaultxyz.ui.routing.composable
import com.defaultxyz.ui.routing.navigation

fun NavGraphBuilder.featureBGraph(navController: NavController) {
    navigation(route = FeatureB, startDestination = FeatureB.ScreenB1) {
        composable(FeatureB.ScreenB1) {
            FeatureBRoute()
        }
    }
}
