package com.example.cryptonite.data.repository.datasource.coin

import com.example.cryptonite.data.api.dto.CoinListDto
import retrofit2.Response

interface CoinRemoteDatasource {

    suspend fun getCoins(
        vs_currency: String,
        order: String,
        per_page: Int
    ) : Response<CoinListDto>


}