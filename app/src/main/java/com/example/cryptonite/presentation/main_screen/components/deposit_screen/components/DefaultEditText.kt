package com.example.cryptonite.presentation.main_screen.components.deposit_screen.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun DefaultEditText(
    onAmountFilled: (userAmount: Double) -> Unit
) {

    val amount = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        elevation = 6.dp
    ) {

        val focusManager = LocalFocusManager.current

        TextField(
            value = amount.value, onValueChange = { amount.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = RoundedCornerShape(10.dp)
                ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface,
                cursorColor = MaterialTheme.colors.onSurface,
                focusedIndicatorColor = MaterialTheme.colors.onSurface,
                unfocusedIndicatorColor = MaterialTheme.colors.onSurface
            ),
            placeholder = { Text(text = "Amount", color = Color.LightGray) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus(
                    force = true
                )

                var amountAsDouble = 0.0

                try {
                    amountAsDouble = amount.value.toDouble()
                } catch (exception: Exception){
                    Log.e("ALERT_DIALOG", "Error: + ${exception.message.toString()}", )
                }

                onAmountFilled(amountAsDouble)
            }),
            maxLines = 1,
            singleLine = true

        )

    }


}