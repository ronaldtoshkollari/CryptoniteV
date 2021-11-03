package com.example.cryptonite.data.repository.datasource.user_coin

import com.example.cryptonite.domain.model.user_coin.UserCoin

interface UserCoinLocalDataSource {

    suspend fun getUserCoinsFromDB(): List<UserCoin>
    suspend fun saveUserCoinToDB(coin: UserCoin)
    suspend fun deleteCoinFromDB(id: String)
    suspend fun clearAll()

}