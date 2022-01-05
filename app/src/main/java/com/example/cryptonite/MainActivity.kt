package com.example.cryptonite

import Navigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.cryptonite.presentation.components.bottom_nav_bar.Screen
import com.example.cryptonite.presentation.components.bottom_nav_bar.composables.BottomNavigationBar
import com.example.cryptonite.presentation.ui.theme.CryptoniteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                    },

                ) { innerPadding ->

                    Box(modifier = Modifier.padding(innerPadding)){
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}
