package com.example.cryptonite.data.repository.datasourceImpl

import com.example.cryptonite.data.db.CoinDao
import com.example.cryptonite.data.repository.datasource.CoinLocalDataSource
import com.example.cryptonite.domain.model.Coin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoinLocalDataSourceImpl (private val coinDao: CoinDao): CoinLocalDataSource {
    override suspend fun getCoinsFromDB(): List<Coin> {
        return coinDao.getCoins()
    }

    override suspend fun saveCoinsToDB(coins: List<Coin>) {

        CoroutineScope(Dispatchers.IO).launch {
            coinDao.insertCoins(coins)
        }

    }

    override suspend fun getCoinByIdFromDB(id: String): Coin? {
        return coinDao.getCoinById(id)
    }

    override suspend fun getCoinByNameFromDB(name: String): Coin? {
        return coinDao.getCoinByName(name)
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            coinDao.clearAll()
        }
    }
}