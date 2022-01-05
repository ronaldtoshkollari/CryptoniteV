package com.example.cryptonite.presentation.screens.home_screen.viewmodel

import com.example.cryptonite.domain.model.coin.Coin
import com.example.cryptonite.util.filters.CoinListFilter
import com.example.cryptonite.util.filters.Filters


data class HomeScreenState(

    //List states
    val coins: List<Coin> = emptyList(),
    val isLoading: Boolean = false,
    val message: String = "",
    val coinListFilter: CoinListFilter = CoinListFilter.All(),
    val isAllTagSelected: Boolean = false,
    val isMarketCapTagSelected: Boolean = false,
    val isPriceTagSelected: Boolean = false,
    val isPriceChangeTagSelected: Boolean = false,
    val isMaxSupplyTagSelected: Boolean = false,
    val isTotalSupplyTagSelected: Boolean = false,
    val isAlphabeticalTagSelected: Boolean = false,
    val isMarketCapDescending: Boolean = false,
    val isPriceDescending: Boolean = false,
    val isPriceChangeDescending: Boolean = false,
    val isMaxSupplyDescending: Boolean = false,
    val isTotalSupplyDescending: Boolean = false,
    val isAlphabeticalDescending: Boolean = false,

    //Search state
    val searchText: String = "",
    val fullCoinList: List<Coin> = emptyList(),

    val filters: List<Filters> = Filters.values().toList()


)
