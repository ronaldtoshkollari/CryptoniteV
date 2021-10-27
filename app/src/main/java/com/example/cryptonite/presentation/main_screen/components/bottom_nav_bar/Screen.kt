package com.example.cryptonite.presentation.main_screen.components.bottom_nav_bar

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Article
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.cryptonite.R

sealed class Screen(val route: String, val title: String, val icon: ImageVector){
    object Home: Screen(route = "home", title = "Home", icon = Icons.Rounded.Home)
    object News: Screen(route = "news", title = "News", icon = Icons.Rounded.Article)
    object Profile: Screen(route = "profile", title = "profile", icon = Icons.Rounded.Person)
}
