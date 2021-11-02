package com.example.cryptonite.domain.repository

import com.example.cryptonite.data.remote.dto.CoinListDto

interface CoinRepository {

    suspend fun getCoins(
        vs_currency: String,
        order: String,
        per_page: Int
    ) : CoinListDto
}