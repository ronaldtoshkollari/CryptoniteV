package com.example.cryptonite.data.repository.datasourceImpl.user_coin

import com.example.cryptonite.data.db.user_coin.UserCoinDao
import com.example.cryptonite.data.repository.datasource.user_coin.UserCoinLocalDataSource
import com.example.cryptonite.domain.model.user_coin.UserCoin
import javax.inject.Inject

class UserCoinLocalDataSourceImpl @Inject constructor(
    private val userCoinDao: UserCoinDao
): UserCoinLocalDataSource {
    override suspend fun getUserCoinsFromDB(): List<UserCoin> {
        return userCoinDao.getUserCoins()
    }

    override suspend fun saveUserCoinToDB(coin: UserCoin) {
        userCoinDao.insertCoin(coin)
    }

    override suspend fun deleteCoinFromDB(id: String) {
        userCoinDao.deleteCoinById(id)
    }

    override suspend fun clearAll() {
        userCoinDao.clearAll()
    }
}