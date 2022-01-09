package com.example.cryptonite.presentation.screens.wallet_screen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptonite.util.common.Response
import com.example.cryptonite.domain.use_case.common_use_cases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class WalletViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {


    private val _state = mutableStateOf(DepositScreenState())
    val state: State<DepositScreenState> = _state

    init {
        getAllCoins()
    }


    fun onEvent(event: DepositScreenEvent) {

    }


    private fun getAllCoins() {

        getCoinsUseCase().onEach { result ->


            when (result) {

                is Response.Success -> {
                    _state.value = state.value.copy(allCoins = result.data ?: emptyList(), isLoading = false)
                }

                is Response.Loading -> {
                    _state.value = state.value.copy(message = "Loading all coins...", isLoading = true)
                }

                is Response.Error -> {
                    _state.value = state.value.copy(message = "Error cannot find coin list.", isLoading = false)
                }

            }

        }.launchIn(viewModelScope)

    }

    fun initialUsersAmounts(){

    }


}