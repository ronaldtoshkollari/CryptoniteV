package com.example.cryptonite.data.remote.repository

import com.example.cryptonite.data.remote.CoinGeckoApi
import com.example.cryptonite.data.remote.dto.CoinListDto
import com.example.cryptonite.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinGeckoApi
): CoinRepository {

    override suspend fun getCoins(vs_currency: String, order: String, per_page: Int): CoinListDto {
        return api.fetchCoins(vs_currency, order, per_page)
    }
}