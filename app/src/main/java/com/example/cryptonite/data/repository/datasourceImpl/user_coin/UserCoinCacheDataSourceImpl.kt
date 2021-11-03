package com.example.cryptonite.data.repository.datasourceImpl.user_coin

import android.os.Build
import com.example.cryptonite.data.repository.datasource.user_coin.UserCoinCacheDataSource
import com.example.cryptonite.domain.model.user_coin.UserCoin

class UserCoinCacheDataSourceImpl : UserCoinCacheDataSource {

    private var userCoinList = ArrayList<UserCoin>()

    override suspend fun getUserCoinsFromCache(): List<UserCoin> {
        return userCoinList
    }

    override suspend fun saveUserCoinsToCache(coins: List<UserCoin>) {
        userCoinList.clear()
        userCoinList = ArrayList(coins)
    }

    override suspend fun saveUserCoinToCache(userCoin: UserCoin) {
        if(!userCoinList.contains(userCoin)){
            userCoinList.add(userCoin)
        }
    }

    override suspend fun clearAll() {
        userCoinList.clear()
    }

    override suspend fun deleteCoinByIdFromCache(id: String) {

        if (Build.VERSION.SDK_INT >= 24) {
            userCoinList.removeIf { it.id == id }
        } else {

            if (!userCoinList.isNullOrEmpty()) {
                var elementToDelete: UserCoin? = null
                userCoinList.forEach { coin ->
                    if (coin.id == id) elementToDelete = coin
                }

                if (elementToDelete != null) userCoinList.remove(elementToDelete)
            }

        }

    }


}