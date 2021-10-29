package com.example.cryptonite.presentation.main_screen.components.home_screen.info_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptonite.R

@Preview
@Composable
fun CardInfo() {

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            colorResource(id = R.color.pink),
            colorResource(id = R.color.purple_500)
        )
    )

    val openDialogDeposit = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
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
                    text = "$ 548712",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    letterSpacing = 3.sp
                )
                Text(
                    text = "Your current balance",
                    color = Color.White.copy(0.8f),
                    fontWeight = FontWeight.Light
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "coin_image",
                modifier = Modifier.align(Alignment.TopEnd)
            )



            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.align(Alignment.BottomStart)
            ) {

                val buttonColors =
                    ButtonDefaults.buttonColors(backgroundColor = Color.White.copy(0.5f), contentColor = Color.White)

                Button(
                    onClick = { openDialogDeposit.value = true },
                    colors = buttonColors,
                    shape = RoundedCornerShape(12.dp)

                ) {

                    Text(
                        text = "Deposit",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Light
                    )

                }

                Spacer(modifier = Modifier.width(15.dp))

                Button(
                    onClick = { /*TODO*/ },
                    colors = buttonColors,
                    shape = RoundedCornerShape(12.dp)

                ) {

                    Text(
                        text = "Withdraw",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Light
                    )

                }

            }


        }
    }


}