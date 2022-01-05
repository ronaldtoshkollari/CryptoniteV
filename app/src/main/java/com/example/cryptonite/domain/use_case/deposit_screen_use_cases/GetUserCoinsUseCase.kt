package com.example.cryptonite.domain.use_case.deposit_screen_use_cases

import com.example.cryptonite.util.common.Response
import com.example.cryptonite.domain.model.user_coin.UserCoin
import com.example.cryptonite.domain.repository.UserCoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUserCoinsUseCase @Inject constructor(
    private val repository: UserCoinRepository
) {


    operator fun invoke(): Flow<Response<List<UserCoin>>> = flow {

        try {

            emit(Response.Loading<List<UserCoin>>())

            val response =
                repository.getCoins()

            emit(Response.Success<List<UserCoin>>(data = response))
        } catch (e: Exception) {

            emit(Response.Error<List<UserCoin>>(message = "An unexpected error occurred."))

        }


    }

}