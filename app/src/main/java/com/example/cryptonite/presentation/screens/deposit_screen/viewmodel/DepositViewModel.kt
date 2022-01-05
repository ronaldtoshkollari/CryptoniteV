package com.example.cryptonite.presentation.screens.deposit_screen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptonite.util.common.Response
import com.example.cryptonite.domain.use_case.common_use_cases.GetCoinsUseCase
import com.example.cryptonite.domain.use_case.deposit_screen_use_cases.DeleteCoinUseCase
import com.example.cryptonite.domain.use_case.deposit_screen_use_cases.GetUserCoinsUseCase
import com.example.cryptonite.domain.use_case.deposit_screen_use_cases.SaveCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DepositViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val getUserCoinsUseCase: GetUserCoinsUseCase,
    private val saveCoinUseCase: SaveCoinUseCase,
    private val deleteCoinUseCase: DeleteCoinUseCase
) : ViewModel() {


    private val _state = mutableStateOf(DepositScreenState())
    val state: State<DepositScreenState> = _state

    init {

        //getUserCoins()
        getAllCoins()
    }


    fun onEvent(event: DepositScreenEvent) {

        when (event) {

            is DepositScreenEvent.AddCoin -> {
                viewModelScope.launch {
                    saveCoinUseCase(event.coin)
                    getUserCoins()
                }
            }

            is DepositScreenEvent.DeleteCoin -> {
                viewModelScope.launch {
                    deleteCoinUseCase(event.id)
                    getUserCoins()
                }
            }


        }


    }


    private fun getUserCoins() {

        getUserCoinsUseCase().onEach { result ->

            when (result) {

                is Response.Success -> {

                    if (result.data != null) {

                        var amount = 0.0
                        result.data.forEach { amount += (it.userAmount * it.coinPrice) }




                        _state.value =
                            DepositScreenState(userCoins = result.data, userTotalAmount = amount)



                    }

                    _state.value = DepositScreenState(userCoins = result.data ?: emptyList())
                }

                is Response.Loading -> {
                    _state.value = DepositScreenState(message = "Loading...")
                }

                is Response.Error -> {
                    _state.value = DepositScreenState(message = "List is empty.")
                }


            }

        }.launchIn(viewModelScope)

    }

    private fun getAllCoins() {

        getCoinsUseCase().onEach { result ->


            when (result) {

                is Response.Success -> {
                    _state.value = state.value.copy(allCoins = result.data ?: emptyList())
                }

                is Response.Loading -> {
                    _state.value = state.value.copy(message = "Loading all coins...")
                }

                is Response.Error -> {
                    _state.value = state.value.copy(message = "Error cannot find coin list.")

                }

            }

        }.launchIn(viewModelScope)

    }


}