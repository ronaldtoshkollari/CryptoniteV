package com.example.cryptonite.data.repository.datasource

import com.example.cryptonite.domain.model.Coin

interface CoinLocalDataSource {

    suspend fun getCoinsFromDB(): List<Coin>
    suspend fun saveCoinsToDB(coins: List<Coin>)
    suspend fun getCoinByIdFromDB(id: String): Coin?
    suspend fun getCoinByNameFromDB(name: String): Coin?
    suspend fun clearAll()

}