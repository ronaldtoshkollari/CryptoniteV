package com.example.cryptonite.domain.use_case.home_screen_use_cases


import android.util.Log
import com.example.cryptonite.common.Constants
import com.example.cryptonite.common.Response
import com.example.cryptonite.data.remote.dto.toCoin
import com.example.cryptonite.domain.model.Coin
import com.example.cryptonite.domain.repository.CoinRepository
import com.example.cryptonite.domain.util.CoinListFilter
import com.example.cryptonite.domain.util.OrderType
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
                repository.getCoins(Constants.VS_CURRENCY, Constants.ORDER, Constants.PER_PAGE)

            Log.i("GetCoinsUseCase", "invoke: Got coins !")


            emit(Response.Success<List<Coin>>(data = response.map { it.toCoin() }))


        } catch (e: Exception) {

            Log.e("GetCoinsUseCase", "" + e.message)
            emit(Response.Error<List<Coin>>(message = "An unexpected error occurred. Check your connection..."))

        }


    }

}