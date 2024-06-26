package com.example.cryptonite.presentation.screens.wallet_screen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.cryptonite.domain.model.coin.Coin


@Composable
fun WalletCoinItem(
    coin: Coin
) {


    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(
                color = if (isSystemInDarkTheme()) Color.Black else Color.White,
                shape = RoundedCornerShape(24.dp)
            )
            .clip(
                RoundedCornerShape(24.dp)
            ),
        elevation = 8.dp,
        color = Color.White
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {

            Image(
                painter = rememberAsyncImagePainter(coin.image),
                contentDescription = "coin_image",
                modifier = Modifier
                    .weight(
                        weight = 1.0f
                    )
                    .clip(MaterialTheme.shapes.small)
                    .width(35.dp)
                    .height(35.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(2.0f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = coin.name,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 22.sp
                )

                Text(
                    text = "0.25395 ${coin.id.uppercase()}",
                    color = Color.LightGray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )

            }

            Row(
                modifier = Modifier.weight(2.0f), horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "${coin.price_change_24h}$ (${coin.price_change_percentage_24h}%)",
                    color = if (coin.price_change_percentage_24h!! > 0) Color.Green else Color.Red,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.width(4.dp))

                Icon(
                    imageVector = Icons.Filled.ExpandLess,
                    contentDescription = "arrow_up",
                    tint = if (coin.price_change_percentage_24h > 0) Color.Green else Color.Red
                )


            }

        }


    }

}