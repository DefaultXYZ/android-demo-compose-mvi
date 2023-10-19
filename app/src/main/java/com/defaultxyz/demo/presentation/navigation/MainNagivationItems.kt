package com.defaultxyz.demo.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.defaultxyz.demo.R
import com.defaultxyz.ui.routing.ScreenRoute

sealed class NavigationItem(
    val route: ScreenRoute,
    @StringRes val title: Int,
    @StringRes val titleDescription: Int,
    val imageVector: ImageVector,
    val selectedImageVector: ImageVector
) {
    object FeatureA : NavigationItem(
        route = ScreenRoute.FeatureA,
        title = R.string.bottom_bar_feature_a_title,
        titleDescription = R.string.bottom_bar_feature_a_accessibility,
        imageVector = Icons.Outlined.List,
        selectedImageVector = Icons.Filled.List
    )

    object FeatureB : NavigationItem(
        route = ScreenRoute.FeatureB,
        title = R.string.bottom_bar_feature_b_title,
        titleDescription = R.string.bottom_bar_feature_b_accessibility,
        imageVector = Icons.Outlined.Edit,
        selectedImageVector = Icons.Filled.Edit
    )

    object FeatureC : NavigationItem(
        route = ScreenRoute.FeatureC,
        title = R.string.bottom_bar_feature_c_title,
        titleDescription = R.string.bottom_bar_feature_c_accessibility,
        imageVector = Icons.Outlined.Person,
        selectedImageVector = Icons.Filled.Person
    )
}
