package com.example.cryptonite.presentation.main_screen.components.deposit_screen

import com.example.cryptonite.domain.model.user_coin.UserCoin

sealed class DepositScreenEvent{
    data class AddCoin(val coin: UserCoin): DepositScreenEvent()
    data class DeleteCoin(val id: String): DepositScreenEvent()
}
