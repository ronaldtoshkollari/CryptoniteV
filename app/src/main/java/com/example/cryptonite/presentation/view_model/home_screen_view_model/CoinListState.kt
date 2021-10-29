package com.example.cryptonite.presentation.view_model.home_screen_view_model

import com.example.cryptonite.domain.model.Coin

data class CoinListState(
    val coins: List<Coin> = emptyList(),
    val isLoading: Boolean = false
)
