package com.example.cryptonite.data.repository.datasourceImpl.coin

import com.example.cryptonite.data.db.coin.CoinDao
import com.example.cryptonite.data.repository.datasource.coin.CoinLocalDataSource
import com.example.cryptonite.domain.model.coin.Coin
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