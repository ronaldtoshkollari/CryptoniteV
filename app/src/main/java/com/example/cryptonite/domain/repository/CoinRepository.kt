package com.example.cryptonite.domain.repository

import com.example.cryptonite.data.remote.dto.CoinListDto
import retrofit2.Response

interface CoinRepository {

    suspend fun getCoins(
        vs_currency: String,
        order: String,
        per_page: Int
    ) : Response<CoinListDto>
}