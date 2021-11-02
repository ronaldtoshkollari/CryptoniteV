package com.example.cryptonite.presentation.main_screen.components.bottom_nav_bar.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cryptonite.R
import com.example.cryptonite.presentation.main_screen.components.bottom_nav_bar.Screen

@Composable
fun BottomNavigationBar(
    navController: NavController,
    onItemClick: (Screen) -> Unit
) {

    val items = listOf(
        Screen.Home,
        Screen.News,
        Screen.Profile
    )


    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(MaterialTheme.colors.background)
    ) {

        items.forEach {

            val selected = it.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(it) },
                icon = {
                    Icon(imageVector = it.icon, contentDescription = it.title)
                },
                selectedContentColor = colorResource(id = R.color.dark_gold),
                unselectedContentColor = Color.LightGray
            )


        }

    }

}