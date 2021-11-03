package com.example.cryptonite.presentation.main_screen.components.home_screen.coin_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.cryptonite.domain.model.coin.Coin

@Composable
fun CoinList(
    coins: List<Coin>
) {


    LazyColumn(contentPadding = PaddingValues(start = 6.dp, end = 6.dp, top = 12.dp, bottom = 12.dp),
    verticalArrangement = Arrangement.spacedBy(6.dp)) {


        items(coins){
            CoinItem(it)
        }

    }

}