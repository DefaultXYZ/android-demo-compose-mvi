package com.defaultxyz.demo.presentation.bottombar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.defaultxyz.demo.presentation.navigation.NavigationItem

@Composable
fun DemoBottomNavBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    navItems: List<NavigationItem>,
    onItemSelected: (NavigationItem) -> Unit
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
                    navController.navigate(item.route.route)
                }
            )
        }
    }
}
