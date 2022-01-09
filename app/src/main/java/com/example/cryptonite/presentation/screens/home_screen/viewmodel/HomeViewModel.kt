package com.example.cryptonite.presentation.screens.home_screen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptonite.util.common.Response
import com.example.cryptonite.domain.use_case.common_use_cases.GetCoinsUseCase
import com.example.cryptonite.domain.use_case.home_screen_use_cases.SearchCoinUseCase
import com.example.cryptonite.domain.use_case.home_screen_use_cases.SortCoinListUseCase
import com.example.cryptonite.util.filters.CoinListFilter
import com.example.cryptonite.util.filters.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val sortCoinListUseCase: SortCoinListUseCase,
    private val searchCoinUseCase: SearchCoinUseCase
) : ViewModel() {


    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    val searchText = mutableStateOf("")

    init {
        getCoins()
    }

    fun onEvent(event: HomeEvent) {

        when (event) {

            is HomeEvent.Sort -> {

                if (!state.value.coins.isNullOrEmpty()) {
                    getSortedCoins(event.coinListFilter)
                }

            }

            is HomeEvent.SearchCoin -> {
                if (!state.value.coins.isNullOrEmpty()) {
                    _state.value = state.value.copy(
                        coins = searchCoinUseCase(
                            _state.value.fullCoinList,
                            event.coinName
                        )
                    )

                }

                if (event.coinName.isEmpty()) {
                    _state.value = state.value.copy(coins = state.value.fullCoinList)
                }


            }

        }

    }


    private fun getCoins() {

        getCoinsUseCase().onEach() { result ->


            when (result) {

                is Response.Success -> {
                    _state.value = HomeScreenState(coins = result.data ?: emptyList())
                    _state.value = state.value.copy(fullCoinList = result.data ?: emptyList())
                }

                is Response.Loading -> {
                    _state.value = HomeScreenState(isLoading = true)
                }

                is Response.Error -> {
                    _state.value = HomeScreenState(message = result.message ?: "An Error occurred")

                }

            }

        }.launchIn(viewModelScope)

    }

    private fun getSortedCoins(coinListFilter: CoinListFilter) {

        _state.value = state.value.copy(
            coins = sortCoinListUseCase(state.value.coins, coinListFilter),
            isLoading = false,
            coinListFilter = coinListFilter,
            message = "",
            isAllTagSelected = coinListFilter is CoinListFilter.All,
            isMarketCapTagSelected = coinListFilter is CoinListFilter.MarketCap,
            isPriceTagSelected = coinListFilter is CoinListFilter.Price,
            isPriceChangeTagSelected = coinListFilter is CoinListFilter.PriceChange,
            isAlphabeticalTagSelected = coinListFilter is CoinListFilter.Alphabetical,
            isMaxSupplyTagSelected = coinListFilter is CoinListFilter.MaxSupply,
            isTotalSupplyTagSelected = coinListFilter is CoinListFilter.TotalSupply,
            isMarketCapDescending = if (coinListFilter is CoinListFilter.MarketCap) coinListFilter.orderType is OrderType.Descending else false,
            isPriceDescending = if (coinListFilter is CoinListFilter.Price) coinListFilter.orderType is OrderType.Descending else false,
            isPriceChangeDescending = if (coinListFilter is CoinListFilter.PriceChange) coinListFilter.orderType is OrderType.Descending else false,
            isAlphabeticalDescending = if (coinListFilter is CoinListFilter.Alphabetical) coinListFilter.orderType is OrderType.Descending else false,
            isMaxSupplyDescending = if (coinListFilter is CoinListFilter.MaxSupply) coinListFilter.orderType is OrderType.Descending else false,
            isTotalSupplyDescending = if (coinListFilter is CoinListFilter.TotalSupply) coinListFilter.orderType is OrderType.Descending else false
        )
    }

    fun onSearchText(searchText: String) {
        this.searchText.value = searchText
    }

}