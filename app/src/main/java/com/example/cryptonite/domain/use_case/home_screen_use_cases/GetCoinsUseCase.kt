package com.example.cryptonite.domain.use_case.home_screen_use_cases


import android.util.Log
import com.example.cryptonite.common.Constants
import com.example.cryptonite.common.Response
import com.example.cryptonite.domain.model.Coin
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



            Log.i("GetCoinsUseCase", "invoke: Got coins ! $response")


            emit(Response.Success<List<Coin>>(data = response))


        } catch (e: Exception) {

            Log.e("GetCoinsUseCase", "" + e.message)
            emit(Response.Error<List<Coin>>(message = "An unexpected error occurred. Check your connection..."))

        }


    }

}