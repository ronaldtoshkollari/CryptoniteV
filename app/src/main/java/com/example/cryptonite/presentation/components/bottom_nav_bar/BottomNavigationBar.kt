package com.example.cryptonite.presentation.components.bottom_nav_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cryptonite.R
import com.example.cryptonite.presentation.components.nav_host.Screens

@Composable
fun BottomNavigationBar(
    navController: NavController,
) {

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(MaterialTheme.colors.background)
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        BottomNavigationItem(
            selected = currentRoute == Screens.Home.name,
            onClick = {
                navController.navigate(Screens.Home.name) {

                    navController.graph.startDestinationRoute?.let { screen_route ->
                        popUpTo(screen_route){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = Screens.Home.name
                )
            },
            selectedContentColor = colorResource(id = R.color.dark_gold),
            unselectedContentColor = Color.LightGray
        )

        BottomNavigationItem(
            selected = currentRoute == Screens.News.name,
            onClick = {
                navController.navigate(Screens.News.name) {

                    navController.graph.startDestinationRoute?.let { screen_route ->
                        popUpTo(screen_route){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_news),
                    contentDescription = Screens.Home.name
                )
            },
            selectedContentColor = colorResource(id = R.color.dark_gold),
            unselectedContentColor = Color.LightGray
        )

        BottomNavigationItem(
            selected = currentRoute == Screens.Profile.name,
            onClick = {
                navController.navigate(Screens.Profile.name) {

                    navController.graph.startDestinationRoute?.let { screen_route ->
                        popUpTo(screen_route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = Screens.Home.name
                )
            },
            selectedContentColor = colorResource(id = R.color.dark_gold),
            unselectedContentColor = Color.LightGray
        )


    }

}