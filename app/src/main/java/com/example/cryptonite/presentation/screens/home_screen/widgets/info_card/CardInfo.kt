package com.example.cryptonite.presentation.screens.home_screen.widgets.info_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cryptonite.R


@Composable
fun CardInfo(navController: NavController) {

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
                    onClick = { navController.navigate("deposit") },
                    colors = buttonColors,
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.height(48.dp)

                ) {

                    Text(
                        text = "Deposit",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = MaterialTheme.typography.button
                    )

                }

                Spacer(modifier = Modifier.width(15.dp))

                Button(
                    onClick = { /*TODO*/ },
                    colors = buttonColors,
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.height(48.dp)

                ) {

                    Text(
                        text = "Withdraw",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = MaterialTheme.typography.button
                    )

                }

            }


        }
    }


}