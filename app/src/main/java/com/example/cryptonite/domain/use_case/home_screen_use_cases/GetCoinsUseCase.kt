package com.example.cryptonite.domain.use_case.home_screen_use_cases

import android.util.Log
import com.example.cryptonite.common.Constants
import com.example.cryptonite.data.remote.dto.toCoin
import com.example.cryptonite.domain.model.Coin
import com.example.cryptonite.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<List<Coin>> = flow {

        try {

            val response =
                repository.getCoins(Constants.VS_CURRENCY, Constants.ORDER, Constants.PER_PAGE)


            if (response.isSuccessful) {
                response.body()?.let { emit(it.map { it.toCoin() }) }


            } else {
                emit(emptyList<Coin>())

            }


        } catch (e: Exception) {
            emit(emptyList<Coin>())

        }


    }

}