package com.example.cryptonite.data.api

import com.example.cryptonite.data.api.dto.CoinListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinGeckoApi {


    @GET("/api/v3/coins/markets")
    suspend fun fetchCoins(
        @Query("vs_currency") vs_currency: String,
        @Query("order") order: String,
        @Query("per_page") per_page: Int
    ): Response<CoinListDto>

}