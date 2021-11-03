package com.example.cryptonite.data.repository.datasource.coin

import com.example.cryptonite.domain.model.coin.Coin

interface CoinLocalDataSource {

    suspend fun getCoinsFromDB(): List<Coin>
    suspend fun saveCoinsToDB(coins: List<Coin>)
    suspend fun getCoinByIdFromDB(id: String): Coin?
    suspend fun getCoinByNameFromDB(name: String): Coin?
    suspend fun clearAll()

}