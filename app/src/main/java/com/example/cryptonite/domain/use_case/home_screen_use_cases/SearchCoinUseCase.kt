package com.example.cryptonite.domain.use_case.home_screen_use_cases

import com.example.cryptonite.domain.model.coin.Coin

class SearchCoinUseCase {


    operator fun invoke(coinList: List<Coin>, coinName: String): List<Coin> {

        return coinList.filter { it.name.lowercase().contains(coinName.lowercase()) }

    }

}