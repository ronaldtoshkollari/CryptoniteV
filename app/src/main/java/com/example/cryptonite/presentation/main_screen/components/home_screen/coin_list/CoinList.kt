package com.example.cryptonite.presentation.main_screen.components.home_screen.coin_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun CoinList() { //TODO: Add coin List

    val coins = listOf("OK")

    LazyColumn(contentPadding = PaddingValues(all = 12.dp),
    verticalArrangement = Arrangement.spacedBy(6.dp)) {

        //TODO: Add coin compose

    }

}