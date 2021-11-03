package com.example.cryptonite.data.repository.datasource.user_coin

import com.example.cryptonite.domain.model.user_coin.UserCoin

interface UserCoinCacheDataSource {

    suspend fun getUserCoinsFromCache(): List<UserCoin>
    suspend fun saveUserCoinsToCache(coins: List<UserCoin>)
    suspend fun saveUserCoinToCache(userCoin: UserCoin)
    suspend fun deleteCoinByIdFromCache(id: String)
    suspend fun clearAll()


}