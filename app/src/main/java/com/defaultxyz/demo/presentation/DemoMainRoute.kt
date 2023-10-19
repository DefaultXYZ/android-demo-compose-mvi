package com.defaultxyz.demo.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.defaultxyz.demo.R
import com.defaultxyz.feature.a.featureAGraph
import com.defaultxyz.feature.b.featureBGraph
import com.defaultxyz.feature.c.featureCGraph
import com.defaultxyz.ui.routing.FeatureRoute
import com.defaultxyz.ui.routing.navigate

private val navigationItems = listOf(
    NavigationItem.FeatureA,
    NavigationItem.FeatureB,
    NavigationItem.FeatureC
)

private val startNavigationItem = navigationItems[0]

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoMainRoute(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    var topBarTitle: Int by remember {
        mutableIntStateOf(startNavigationItem.title)
    }
    Scaffold(
        modifier = modifier,
        bottomBar = {
            DemoBottomNavBar(
                navController = navController,
                navItems = navigationItems,
                onItemSelected = {
                    topBarTitle = it.title
                }
            )
        },
        topBar = {
            DemoTopBar(title = stringResource(topBarTitle))
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = FeatureRoute.FeatureA.route
        ) {
            featureAGraph(navController)
            featureBGraph(navController)
            featureCGraph(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoTopBar(
    modifier: Modifier = Modifier,
    title: String,
) {
    TopAppBar(
        modifier = modifier,
        title = { androidx.compose.material3.Text(text = title) }
    )
}

@Composable
fun DemoBottomNavBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    navItems: List<NavigationItem>,
    onItemSelected: (NavigationItem) -> Unit,
) {
    BottomNavigation(modifier = modifier) {
        val navBackStackEntryState by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntryState?.destination

        navItems.forEach { item ->
            val selected = currentDestination?.hierarchy?.any { it.route == item.route.route } == true
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = if (selected) item.selectedImageVector else item.imageVector,
                        contentDescription = stringResource(item.titleDescription)
                    )
                },
                label = {
                    Text(text = stringResource(item.title))
                },
                selected = selected,
                onClick = {
                    onItemSelected(item)
                    navController.navigate(item.route)
                }
            )
        }
    }
}

enum class NavigationItem(
    val route: FeatureRoute,
    @StringRes val title: Int,
    @StringRes val titleDescription: Int,
    val imageVector: ImageVector,
    val selectedImageVector: ImageVector,
) {
    FeatureA(
        route = FeatureRoute.FeatureA,
        title = R.string.bottom_bar_feature_a_title,
        titleDescription = R.string.bottom_bar_feature_a_accessibility,
        imageVector = Icons.Outlined.List,
        selectedImageVector = Icons.Filled.List
    ),
    FeatureB(
        route = FeatureRoute.FeatureB,
        title = R.string.bottom_bar_feature_b_title,
        titleDescription = R.string.bottom_bar_feature_b_accessibility,
        imageVector = Icons.Outlined.Edit,
        selectedImageVector = Icons.Filled.Edit
    ),
    FeatureC(
        route = FeatureRoute.FeatureC,
        title = R.string.bottom_bar_feature_c_title,
        titleDescription = R.string.bottom_bar_feature_c_accessibility,
        imageVector = Icons.Outlined.Person,
        selectedImageVector = Icons.Filled.Person
    ),
}
