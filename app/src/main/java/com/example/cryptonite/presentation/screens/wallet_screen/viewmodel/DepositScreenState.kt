package com.example.cryptonite.presentation.screens.wallet_screen.viewmodel


import com.example.cryptonite.domain.model.coin.Coin

data class DepositScreenState(

    val userTotalAmount: Double = 0.0,
    val hasProfit: Boolean = false,
    val profitAmount: Double = 0.0,
    val profitPercentage: Double = 0.0,
    val message: String = "",
    val allCoins: List<Coin> = emptyList(),
    val isLoading: Boolean = false

)
