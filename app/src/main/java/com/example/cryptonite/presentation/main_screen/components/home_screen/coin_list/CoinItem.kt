package com.example.cryptonite.presentation.main_screen.components.home_screen.coin_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.cryptonite.R
import com.example.cryptonite.domain.model.Coin
import java.math.BigDecimal


@Composable
fun CoinItem(
    coin: Coin
) {

    val corner = RoundedCornerShape(20.dp)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(corner)
            .background(MaterialTheme.colors.surface)
            .padding(5.dp),
        elevation = if(isSystemInDarkTheme()) 0.dp else 8.dp,
        shape = corner
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                /* TODO: Change to Coil */
                painter = rememberImagePainter(coin.image),
                contentDescription = "coin_image",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .weight(1.0f)
            )

            Column(
                verticalArrangement = Arrangement.Center, modifier = Modifier
                    .width(100.dp)
                    .weight(2.0f)
            ) {

                Text(
                    text = coin.name ?: "-",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = coin.symbol ?: "-",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface.copy(0.5f),
                    textAlign = TextAlign.Start,
                    maxLines = 1
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier.weight(1.5f)
            ) {

                Text(
                    text = if (coin.current_price != null) "$ " + BigDecimal(coin.current_price).toPlainString() else "-",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,

                    )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = if (coin.price_change_percentage_24h != null) coin.price_change_percentage_24h.toString() + " %" else "-",
                    style = MaterialTheme.typography.body1,
                    color = if (coin.price_change_percentage_24h != null && coin.price_change_percentage_24h < 0) Color.Red else Color.Green,
                    textAlign = TextAlign.End
                )
            }


        }

    }

}