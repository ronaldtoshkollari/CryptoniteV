package com.example.cryptonite.presentation.main_screen.components.home_screen

import com.example.cryptonite.domain.util.CoinListFilter

sealed class HomeEvent{
    data class Sort(val coinListFilter: CoinListFilter): HomeEvent()
    data class SearchCoin(val coinName: String): HomeEvent()
}
