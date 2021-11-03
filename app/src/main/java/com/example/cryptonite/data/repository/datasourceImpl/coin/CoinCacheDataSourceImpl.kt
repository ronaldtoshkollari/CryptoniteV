package com.example.cryptonite.data.repository.datasourceImpl.coin

import com.example.cryptonite.data.repository.datasource.coin.CoinCacheDataSource
import com.example.cryptonite.domain.model.coin.Coin
import java.util.ArrayList

class CoinCacheDataSourceImpl: CoinCacheDataSource {

    private var coinList = ArrayList<Coin>()

    override suspend fun getCoinsFromCache(): List<Coin> {
        return coinList
    }

    override suspend fun saveCoinsToCache(coins: List<Coin>) {
        coinList.clear()
        coinList = ArrayList(coins)
    }

    override suspend fun getCoinByIdFromCache(id: String): Coin? {
        val filteredCoins = coinList.filter { coin ->
            coin.id == id
        }

        return filteredCoins.first()
    }

    override suspend fun getCoinByNameFromCache(name: String): Coin? {
        val filteredCoins = coinList.filter { coin ->
            coin.id == name
        }

        return filteredCoins.first()
    }
}