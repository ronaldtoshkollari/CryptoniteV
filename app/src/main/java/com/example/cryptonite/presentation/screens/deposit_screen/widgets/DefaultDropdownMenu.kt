package com.example.cryptonite.presentation.screens.deposit_screen.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cryptonite.domain.model.coin.Coin

@Composable
fun DefaultDropdownMenu(
    items: List<Coin>,
    onCoinSelect: (Coin) -> Unit
) {

    val expanded = remember {
        mutableStateOf(false)
    }


    val disabledValue = items.first().name
    val selectedIndex = remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {


        DropDownItem(name = items[selectedIndex.value].name, image = items[selectedIndex.value].image) {
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

                DropDownItem(name = s.name, image = s.image) {
                    selectedIndex.value = index
                    expanded.value = false
                    onCoinSelect(s)
                }
            }
        }

    }

}