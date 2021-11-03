package com.example.cryptonite.domain.repository

import com.example.cryptonite.domain.model.user_coin.UserCoin

interface UserCoinRepository {

    suspend fun getCoins(): List<UserCoin>
    suspend fun saveCoin(coin: UserCoin)
    suspend fun deleteCoinById(id: String)
    suspend fun clearAll()

}