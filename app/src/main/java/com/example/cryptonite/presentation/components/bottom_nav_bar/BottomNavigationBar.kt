package com.example.cryptonite.presentation.components.bottom_nav_bar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cryptonite.R
import com.example.cryptonite.presentation.components.nav_host.Screens

@Composable
fun BottomNavigationBar(
    isVisible: Boolean,
    onNavigationItemClick: (route: String) -> Unit
) {

    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.background,
            elevation = 5.dp,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(MaterialTheme.colors.background)
        ) {

            BottomNavigationItem(
                selected = true,
                onClick = { onNavigationItemClick(Screens.Home.name) },
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
                selected = false,
                onClick = { onNavigationItemClick(Screens.News.name) },
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
                selected = false,
                onClick = { onNavigationItemClick(Screens.Profile.name) },
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
}