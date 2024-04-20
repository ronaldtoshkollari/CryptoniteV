package com.example.cryptonite.presentation.screens.home_screen.widgets.info_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cryptonite.R
import com.example.cryptonite.presentation.components.nav_host.Screens

@Composable
fun CardInfo(
    onCardClick: (route: String) -> Unit
) {

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            colorResource(id = R.color.pink),
            colorResource(id = R.color.purple_500)
        )
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(24.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradientBrush)
                .padding(24.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(
                    text = "$548712",
                    color = Color.White,
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = "Your current balance",
                    color = Color.White.copy(0.8f),
                    style = MaterialTheme.typography.caption
                )
            }

            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.align(Alignment.BottomStart)
            ) {

                val buttonColors =
                    ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary, contentColor = MaterialTheme.colors.onSecondary)

                Button(
                    onClick = { onCardClick(Screens.Wallet.name) },
                    colors = buttonColors,
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.height(48.dp)

                ) {

                    Text(
                        text = "My Wallet",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = MaterialTheme.typography.button
                    )

                }
            }
        }
    }
}