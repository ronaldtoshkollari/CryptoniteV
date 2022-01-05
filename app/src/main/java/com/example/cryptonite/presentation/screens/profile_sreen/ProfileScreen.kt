package com.example.cryptonite.presentation.screens.profile_sreen

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.cryptonite.presentation.components.bottom_nav_bar.BottomNavigationBar

@Composable
fun ProfileScreen(navController: NavController){
    Scaffold(bottomBar = {
        BottomNavigationBar(navController = navController)
    }) {

    }
}