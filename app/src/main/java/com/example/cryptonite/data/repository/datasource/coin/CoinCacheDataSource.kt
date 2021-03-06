package com.example.cryptonite.data.repository.datasource.coin

import com.example.cryptonite.domain.model.coin.Coin

interface CoinCacheDataSource {

    suspend fun getCoinsFromCache(): List<Coin>
    suspend fun saveCoinsToCache(coins: List<Coin>)
    suspend fun getCoinByIdFromCache(id: String): Coin?
    suspend fun getCoinByNameFromCache(name: String): Coin?
}