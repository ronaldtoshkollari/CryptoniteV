package com.example.cryptonite.data.remote

import com.example.cryptonite.data.remote.dto.CoinListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinGeckoApi {


    @GET("/api/v3/coins/markets")
    suspend fun fetchCoins(
        @Query("vs_currency") vs_currency: String,
        @Query("order") order: String,
        @Query("per_page") per_page: Int
    ): CoinListDto

}