package com.example.cryptonite.di

import android.content.Context
import androidx.room.Room
import com.example.cryptonite.common.Constants
import com.example.cryptonite.data.api.CoinGeckoApi
import com.example.cryptonite.data.db.CoinDao
import com.example.cryptonite.data.db.CoinDatabase
import com.example.cryptonite.data.repository.CoinRepositoryImpl
import com.example.cryptonite.data.repository.datasource.CoinCacheDataSource
import com.example.cryptonite.data.repository.datasource.CoinLocalDataSource
import com.example.cryptonite.data.repository.datasource.CoinRemoteDatasource
import com.example.cryptonite.data.repository.datasourceImpl.CoinCacheDataSourceImpl
import com.example.cryptonite.data.repository.datasourceImpl.CoinLocalDataSourceImpl
import com.example.cryptonite.data.repository.datasourceImpl.CoinRemoteDataSourceImpl
import com.example.cryptonite.domain.repository.CoinRepository
import com.example.cryptonite.domain.use_case.home_screen_use_cases.SearchCoinUseCase
import com.example.cryptonite.domain.use_case.home_screen_use_cases.SortCoinListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    } //API


    @Provides
    @Singleton
    fun provideRoomDatabaseInstance(@ApplicationContext appContext: Context): CoinDatabase {

        return Room.databaseBuilder(
            appContext,
            CoinDatabase::class.java,
            "Crypto Coin Database"
        ).build()

    } //Room Instance

    @Provides
    fun provideCoinDao(coinDatabase: CoinDatabase): CoinDao {
        return coinDatabase.coinDao()
    } //CoinDao

    @Provides
    @Singleton
    fun provideCoinCacheRepository(): CoinCacheDataSource {
        return CoinCacheDataSourceImpl()
    } //Cache Repo

    @Provides
    @Singleton
    fun provideCoinLocalRepository(coinDao: CoinDao): CoinLocalDataSource {
        return CoinLocalDataSourceImpl(coinDao)
    } //Local(Room) Repo

    @Provides
    @Singleton
    fun provideCoinRemoteRepository(coinGeckoApi: CoinGeckoApi): CoinRemoteDatasource {
        return CoinRemoteDataSourceImpl(coinGeckoApi)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(
        cacheDataSource: CoinCacheDataSource,
        localDataSource: CoinLocalDataSource,
        remoteDatasource: CoinRemoteDatasource
    ): CoinRepository {
        return CoinRepositoryImpl(
            coinCacheDataSource = cacheDataSource,
            coinLocalDataSource = localDataSource,
            coinRemoteDatasource = remoteDatasource
        )
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