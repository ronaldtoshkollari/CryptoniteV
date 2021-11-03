package com.example.cryptonite.data.repository

import android.util.Log
import com.example.cryptonite.data.repository.datasource.user_coin.UserCoinCacheDataSource
import com.example.cryptonite.data.repository.datasource.user_coin.UserCoinLocalDataSource
import com.example.cryptonite.domain.model.user_coin.UserCoin
import com.example.cryptonite.domain.repository.UserCoinRepository
import javax.inject.Inject

class UserCoinRepositoryImpl @Inject constructor(
    private val userCoinCacheDataSource: UserCoinCacheDataSource,
    private val userCoinLocalDataSource: UserCoinLocalDataSource
) : UserCoinRepository {


    override suspend fun getCoins(): List<UserCoin> {
        return getUserCoinsFromCache()
    }

    override suspend fun saveCoin(coin: UserCoin) {

        userCoinCacheDataSource.saveUserCoinToCache(coin)
        userCoinLocalDataSource.saveUserCoinToDB(coin)

    }

    override suspend fun deleteCoinById(id: String) {
        userCoinCacheDataSource.deleteCoinByIdFromCache(id)
        userCoinLocalDataSource.deleteCoinFromDB(id)
    }

    override suspend fun clearAll() {
        userCoinCacheDataSource.clearAll()
        userCoinLocalDataSource.clearAll()
    }

    private suspend fun getUserCoinsFromCache(): List<UserCoin> {

        lateinit var userCoins: List<UserCoin>

        try {
            userCoins = userCoinCacheDataSource.getUserCoinsFromCache()
        } catch (exception: Exception) {
            Log.e("CACHE", "Error: ${exception.message.toString()} ")
        }

        if (userCoins.isEmpty()) {
            userCoins = getUserCoinsFromDB()
            userCoinCacheDataSource.saveUserCoinsToCache(userCoins)
        }

        return userCoins

    }

    private suspend fun getUserCoinsFromDB(): List<UserCoin> {
        lateinit var userCoins: List<UserCoin>

        try {
            userCoins = userCoinLocalDataSource.getUserCoinsFromDB()
        } catch (exception: Exception) {
            Log.e("ROOM", "Error: ${exception.message.toString()} ")
        }

        return if (userCoins.isEmpty())
            emptyList()
        else
            userCoins

    }


}