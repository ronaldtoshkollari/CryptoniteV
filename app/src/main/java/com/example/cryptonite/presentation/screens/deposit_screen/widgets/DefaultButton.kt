package com.example.cryptonite.presentation.screens.deposit_screen.widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit
) {


    Button(
        onClick = { onClick() }, modifier = Modifier
            .height(60.dp)
            .padding(12.dp),
        shape = RoundedCornerShape(50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
    ) {

        Text(
            text = text,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxSize()
        )

    }

}