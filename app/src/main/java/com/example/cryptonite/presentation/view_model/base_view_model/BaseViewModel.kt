package com.example.cryptonite.presentation.view_model.base_view_model

import androidx.lifecycle.ViewModel
import com.example.cryptonite.domain.model.coin.Coin
import com.example.cryptonite.domain.use_case.common_use_cases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
open class BaseViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    val coins: List<Coin> = emptyList()



}