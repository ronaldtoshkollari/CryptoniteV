package com.example.cryptonite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.rememberNavController
import com.example.cryptonite.presentation.main_screen.components.bottom_nav_bar.Screen
import com.example.cryptonite.presentation.main_screen.components.bottom_nav_bar.composables.BottomNavigationBar
import com.example.cryptonite.presentation.main_screen.components.bottom_nav_bar.composables.Navigation
import com.example.cryptonite.presentation.ui.theme.CryptoniteTheme

class MainActivity : ComponentActivity() {

    private val currentRoute = mutableStateOf(Screen.Home.route)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoniteTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController, onItemClick = {navController.navigate(it.route)})
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}
