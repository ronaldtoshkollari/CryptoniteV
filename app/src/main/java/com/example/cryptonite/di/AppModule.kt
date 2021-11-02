package com.example.cryptonite.di

import com.example.cryptonite.common.Constants
import com.example.cryptonite.data.remote.CoinGeckoApi
import com.example.cryptonite.data.remote.repository.CoinRepositoryImpl
import com.example.cryptonite.domain.repository.CoinRepository
import com.example.cryptonite.domain.use_case.home_screen_use_cases.SearchCoinUseCase
import com.example.cryptonite.domain.use_case.home_screen_use_cases.SortCoinListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideGeckoCoinApi(): CoinGeckoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGeckoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinGeckoApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    fun provideSortCoinsUseCase(): SortCoinListUseCase {
        return SortCoinListUseCase()
    }

    @Provides
    fun provideSearchCoinUseCase(): SearchCoinUseCase {
        return SearchCoinUseCase()
    }

}