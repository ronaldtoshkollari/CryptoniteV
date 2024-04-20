package com.example.cryptonite.presentation.screens.splash_screen

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.example.cryptonite.R
import com.example.cryptonite.presentation.components.nav_host.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    var scaleState by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        if (scaleState) 0.5f else 0.8f,
        animationSpec = repeatable(
            iterations = 3,
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    LaunchedEffect(key1 = true) {
        scaleState = true
        delay(3500L)
        navController.navigate(Screens.Home.name) {
            popUpTo(Screens.Splash.name) {
                inclusive = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_bitcoin_splash),
            contentDescription = "Bitcoin Image",
            modifier = Modifier.scale(scale)
        )

    }

}