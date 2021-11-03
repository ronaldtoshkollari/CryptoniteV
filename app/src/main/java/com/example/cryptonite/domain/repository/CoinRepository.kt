package com.example.cryptonite.domain.repository

import com.example.cryptonite.domain.model.Coin

interface CoinRepository {

    suspend fun getCoins(): List<Coin>
    suspend fun getCoinById(id: String): Coin?
    suspend fun getCoinByName(name: String): Coin?
}