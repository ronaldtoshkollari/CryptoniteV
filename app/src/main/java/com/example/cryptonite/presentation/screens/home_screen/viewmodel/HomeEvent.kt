package com.example.cryptonite.presentation.screens.home_screen.viewmodel

import com.example.cryptonite.util.filters.CoinListFilter

sealed class HomeEvent{
    data class Sort(val coinListFilter: CoinListFilter): HomeEvent()
    data class SearchCoin(val coinName: String): HomeEvent()
}
