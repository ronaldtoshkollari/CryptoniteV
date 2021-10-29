package com.example.cryptonite.presentation.view_model.home_screen_view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptonite.domain.use_case.home_screen_use_cases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {


    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }



    private fun getCoins() {

        getCoinsUseCase().onEach { result ->

            //TODO: Add loading state
            _state.value = CoinListState(coins = result, false)

        }.launchIn(viewModelScope)

    }

}