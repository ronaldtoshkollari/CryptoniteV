package com.example.cryptonite.domain.use_case.deposit_screen_use_cases

import com.example.cryptonite.domain.model.user_coin.UserCoin
import com.example.cryptonite.domain.repository.UserCoinRepository
import javax.inject.Inject

class SaveCoinUseCase @Inject constructor(
    private val repository: UserCoinRepository
) {

    suspend operator fun invoke(coin: UserCoin) {
        repository.saveCoin(coin)
    }

}