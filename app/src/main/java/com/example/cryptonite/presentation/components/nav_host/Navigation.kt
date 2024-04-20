package com.example.cryptonite.presentation.components.nav_host

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptonite.presentation.components.bottom_nav_bar.BottomNavigationBar
import com.example.cryptonite.presentation.screens.home_screen.HomeScreen
import com.example.cryptonite.presentation.screens.news_screen.NewsScreen
import com.example.cryptonite.presentation.screens.profile_sreen.ProfileScreen
import com.example.cryptonite.presentation.screens.splash_screen.SplashScreen
import com.example.cryptonite.presentation.screens.wallet_screen.DepositScreen

@Composable
fun Navigation() {
    
    val navController = rememberNavController()
    val useBottomNavigation by navController.shouldShowBottomNavigationAsState(shouldHideRoutes = listOf(Screens.Splash.name))

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                isVisible = !useBottomNavigation,
                onNavigationItemClick = { route -> navController.navigateSingleTop(route) }
            )
        },
        modifier = Modifier.safeDrawingPadding()
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screens.Splash.name,
            modifier = Modifier.padding(padding)
        ) {

            composable(Screens.Home.name) {
                HomeScreen(onCardInfoClick = { route -> navController.navigate(route) })
            }

            composable(Screens.News.name) {
                NewsScreen(navController = navController)
            }

            composable(Screens.Profile.name) {
                ProfileScreen(navController = navController)
            }

            composable(Screens.Wallet.name){
                DepositScreen(navController = navController)
            }

            composable(Screens.Splash.name) {
                SplashScreen(navController = navController)
            }
        }
    }


}
