package com.example.cryptonite.data.repository.datasourceImpl

import com.example.cryptonite.data.api.CoinGeckoApi
import com.example.cryptonite.data.api.dto.CoinListDto
import com.example.cryptonite.data.repository.datasource.CoinRemoteDatasource
import retrofit2.Response
import javax.inject.Inject

class CoinRemoteDataSourceImpl @Inject constructor(private val coinService: CoinGeckoApi):CoinRemoteDatasource {


    override suspend fun getCoins(vs_currency: String, order: String, per_page: Int): Response<CoinListDto> {
        return coinService.fetchCoins(vs_currency = vs_currency, order = order, per_page = per_page)
    }


}