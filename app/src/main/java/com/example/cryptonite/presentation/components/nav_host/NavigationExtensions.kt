package com.example.cryptonite.presentation.components.nav_host

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController

fun NavController.navigateSingleTop(route: String) {
    navigate(route) {
        graph.startDestinationRoute?.let {  screenRoute ->
            popUpTo(screenRoute){
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Stable
@Composable
fun NavController.shouldShowBottomNavigationAsState(shouldHideRoutes: List<String>) : State<Boolean> {
    val shouldShowBottomNavigation = rememberSaveable { mutableStateOf(false) }
    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            shouldShowBottomNavigation.value = shouldHideRoutes.any { it == destination.route }
        }
        addOnDestinationChangedListener(listener)
        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }
    return shouldShowBottomNavigation
}