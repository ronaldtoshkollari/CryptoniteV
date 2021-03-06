package com.example.cryptonite.data.repository

import android.util.Log
import com.example.cryptonite.util.common.Constants
import com.example.cryptonite.data.api.dto.toCoin
import com.example.cryptonite.data.repository.datasource.coin.CoinCacheDataSource
import com.example.cryptonite.data.repository.datasource.coin.CoinLocalDataSource
import com.example.cryptonite.data.repository.datasource.coin.CoinRemoteDatasource
import com.example.cryptonite.domain.model.coin.Coin
import com.example.cryptonite.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinCacheDataSource: CoinCacheDataSource,
    private val coinLocalDataSource: CoinLocalDataSource,
    private val coinRemoteDatasource: CoinRemoteDatasource
): CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return getCoinsFromCache()
    }

    override suspend fun getCoinById(id: String): Coin? {
        return getCoinByIdFromCache(id)
    }

    override suspend fun getCoinByName(name: String): Coin? {
        return getCoinByNameFromCache(name)
    }

    private suspend fun getCoinsFromAPI(): List<Coin> {

        lateinit var coinList: List<Coin>

        try {
            val response = coinRemoteDatasource.getCoins(Constants.VS_CURRENCY, Constants.ORDER, Constants.PER_PAGE)
            val body = response.body()


            if(body != null){
                coinList = body.map { it.toCoin() }

            }
        } catch (exception: Exception){
            Log.e("API", "Error: ${exception.message.toString()}")

        }

        return coinList

    }

    private suspend fun getCoinsFromDB(): List<Coin> {

        lateinit var coinList: List<Coin>

        try {
            coinList = coinLocalDataSource.getCoinsFromDB()
        } catch (exception: Exception){
            Log.e("ROOM", "Error: ${exception.message.toString()}")
        }

        if(coinList.isNotEmpty()){
            return coinList
        }else{
            coinList = getCoinsFromAPI()
            coinLocalDataSource.saveCoinsToDB(coinList)
        }

        return coinList



    }

    private suspend fun getCoinsFromCache(): List<Coin> {
        lateinit var coinList: List<Coin>

        try {
            coinList = coinCacheDataSource.getCoinsFromCache()
        } catch (exception: Exception) {
            Log.e("CACHE", "Error: ${exception.message.toString()}")
        }

        if(coinList.isNotEmpty()){
            return coinList
        }else{
            coinList = getCoinsFromDB()
            coinCacheDataSource.saveCoinsToCache(coinList)
        }

        return coinList
    }

    private suspend fun getCoinByIdFromDB(id: String): Coin? {
        var coin: Coin? = null

        try {
            coin = coinLocalDataSource.getCoinByIdFromDB(id)
        } catch (exception: Exception){
            Log.e("ROOM", "Error: ${exception.message.toString()}")
        }

        return coin

    }

    private suspend fun getCoinByIdFromCache(id: String): Coin? {
        var coin: Coin? = null

        try {
            coin = coinCacheDataSource.getCoinByIdFromCache(id)
        } catch (exception: Exception){
            Log.e("ROOM", "Error: ${exception.message.toString()}")
        }

        if(coin != null){
            return coin
        }else {
            coin = getCoinByIdFromDB(id)
        }

        return coin
    }

    private suspend fun getCoinByNameFromDB(name: String): Coin? {
        var coin: Coin? = null

        try {
            coin = coinLocalDataSource.getCoinByNameFromDB(name)
        } catch (exception: Exception){
            Log.e("ROOM", "Error: ${exception.message.toString()}")
        }

        return coin

    }

    private suspend fun getCoinByNameFromCache(name: String): Coin? {
        var coin: Coin? = null

        try {
            coin = coinCacheDataSource.getCoinByNameFromCache(name)
        } catch (exception: Exception){
            Log.e("ROOM", "Error: ${exception.message.toString()}")
        }

        if(coin != null){
            return coin
        }else {
            coin = getCoinByNameFromDB(name)
        }

        return coin
    }

}