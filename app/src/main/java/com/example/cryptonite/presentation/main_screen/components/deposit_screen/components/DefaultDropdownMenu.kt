package com.example.cryptonite.presentation.main_screen.components.deposit_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultDropdownMenu() {

    var expanded = remember {
        mutableStateOf(false)
    }

    val items = listOf(
        "Bitcoin",
        "Ethereum",
        "Binance Coin",
        "Tether",
        "Cardano",
        "Solana",
        "XRP",
        "Polkabot",
        "Shiba Inu"
    )
    val disabledValue = "Bitcoin"
    var selectedIndex = remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {


        DropDownItem(name = items[selectedIndex.value]) {
            expanded.value = true
        }

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier
                .width(400.dp)
                .height(400.dp)
                .background(MaterialTheme.colors.background)

        ) {
            items.forEachIndexed { index, s ->

                DropDownItem(name = s) {
                    selectedIndex.value = index
                    expanded.value = false
                }
            }
        }

    }

}