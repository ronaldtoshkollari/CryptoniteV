package com.example.cryptonite.presentation.main_screen.components.home_screen.coin_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptonite.R


@Preview
@Composable
fun CoinItem() {

    val corner = RoundedCornerShape(20.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(corner)
            .background(colorResource(id = R.color.silver_grey))
            .padding(5.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                /* TODO: Change to Coil */
                painterResource(id = R.drawable.ic_news),
                contentDescription = "coin_image"
            )

            Column(verticalArrangement = Arrangement.Center) {

                Text(
                    text = "Bitcoin",
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "BTC",
                    style = MaterialTheme.typography.body1,
                    color = Color.LightGray,
                    textAlign = TextAlign.Start
                )
            }

            Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End) {

                Text(
                    text = "60.000$",
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "+5%",
                    style = MaterialTheme.typography.body1,
                    color = Color.Yellow,
                    textAlign = TextAlign.End
                )
            }
            




        }

    }

}