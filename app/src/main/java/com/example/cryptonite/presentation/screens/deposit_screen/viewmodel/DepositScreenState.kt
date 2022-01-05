package com.example.cryptonite.presentation.screens.deposit_screen.viewmodel


import com.example.cryptonite.domain.model.coin.Coin
import com.example.cryptonite.domain.model.user_coin.UserCoin

data class DepositScreenState(

    val userCoins: List<UserCoin> = emptyList(),
    val userTotalAmount: Double = 0.0,
    val hasProfit: Boolean = false,
    val profitAmount: Double = 0.0,
    val profitPercentage: Double = 0.0,
    val message: String = "",

    //for alert dialog
    val userCoin: UserCoin? = null,
    var coinToBeAddedAmount: Double = 0.0,
    var coin: Coin? = null,
    val allCoins: List<Coin> = emptyList()


)
