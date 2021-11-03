package com.example.cryptonite.domain.use_case.common_use_cases

import com.example.cryptonite.common.Response
import com.example.cryptonite.domain.model.coin.Coin
import com.example.cryptonite.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Response<List<Coin>>> = flow {

        try {

            emit(Response.Loading<List<Coin>>())

            val response =
                repository.getCoins()

            emit(Response.Success<List<Coin>>(data = response))
        } catch (e: Exception) {

            emit(Response.Error<List<Coin>>(message = "An unexpected error occurred. Check your connection..."))

        }


    }

}