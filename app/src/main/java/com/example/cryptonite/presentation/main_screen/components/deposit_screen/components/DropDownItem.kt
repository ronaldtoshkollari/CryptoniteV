package com.example.cryptonite.presentation.main_screen.components.deposit_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter


@Composable
fun DropDownItem(
    name: String,
    image: String?,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(3.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Spacer(modifier = Modifier.width(12.dp))

        Image(
            painter = rememberImagePainter(image),
            contentDescription = "crypto_icon",
            modifier = Modifier.height(50.dp).width(50.dp)

            )

        Spacer(modifier = Modifier.width(18.dp))

        Text(
            text = name,
            textAlign = TextAlign.Center,
            color = Color.Black
            )

    }

}