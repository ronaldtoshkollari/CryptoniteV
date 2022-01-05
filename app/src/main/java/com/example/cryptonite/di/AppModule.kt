package com.example.cryptonite.di

import android.content.Context
import androidx.room.Room
import com.example.cryptonite.util.common.Constants
import com.example.cryptonite.data.api.CoinGeckoApi
import com.example.cryptonite.data.db.coin.CoinDao
import com.example.cryptonite.data.db.CryptoniteDatabase
import com.example.cryptonite.data.db.user_coin.UserCoinDao
import com.example.cryptonite.data.repository.CoinRepositoryImpl
import com.example.cryptonite.data.repository.UserCoinRepositoryImpl
import com.example.cryptonite.data.repository.datasource.coin.CoinCacheDataSource
import com.example.cryptonite.data.repository.datasource.coin.CoinLocalDataSource
import com.example.cryptonite.data.repository.datasource.coin.CoinRemoteDatasource
import com.example.cryptonite.data.repository.datasource.user_coin.UserCoinCacheDataSource
import com.example.cryptonite.data.repository.datasource.user_coin.UserCoinLocalDataSource
import com.example.cryptonite.data.repository.datasourceImpl.coin.CoinCacheDataSourceImpl
import com.example.cryptonite.data.repository.datasourceImpl.coin.CoinLocalDataSourceImpl
import com.example.cryptonite.data.repository.datasourceImpl.coin.CoinRemoteDataSourceImpl
import com.example.cryptonite.data.repository.datasourceImpl.user_coin.UserCoinCacheDataSourceImpl
import com.example.cryptonite.data.repository.datasourceImpl.user_coin.UserCoinLocalDataSourceImpl
import com.example.cryptonite.domain.repository.CoinRepository
import com.example.cryptonite.domain.repository.UserCoinRepository
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

    /*
        Retrofit API instance
     */

    @Provides
    @Singleton
    fun provideGeckoCoinApi(): CoinGeckoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGeckoApi::class.java)
    } //API

    /*
        Room instance
     */


    @Provides
    @Singleton
    fun provideRoomDatabaseInstance(@ApplicationContext appContext: Context): CryptoniteDatabase {

        return Room.databaseBuilder(
            appContext,
            CryptoniteDatabase::class.java,
            "Crypto Coin Database"
        ).build()

    } //Room Instance

    /*
        Coin Repository dependencies
     */

    @Provides
    fun provideCoinDao(cryptoniteDatabase: CryptoniteDatabase): CoinDao {
        return cryptoniteDatabase.coinDao()
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


    /*
        User Coin Dependencies
     */

    @Provides
    @Singleton
    fun provideUserCoinCacheRepository(): UserCoinCacheDataSource {
        return UserCoinCacheDataSourceImpl()
    } // Cache datasource userCoin

    @Provides
    fun provideUserCoinDao(cryptoniteDatabase: CryptoniteDatabase): UserCoinDao {
        return cryptoniteDatabase.userCoinDao()
    } // UserCoin Dao

    @Provides
    @Singleton
    fun provideUserCoinLocalRepository(userCoinDao: UserCoinDao): UserCoinLocalDataSource {
        return UserCoinLocalDataSourceImpl(userCoinDao)
    } // Local datasource userCoin


    @Provides
    @Singleton
    fun provideUserCoinRepository(
        cache: UserCoinCacheDataSource,
        local: UserCoinLocalDataSource
    ): UserCoinRepository {
        return UserCoinRepositoryImpl(
            userCoinCacheDataSource = cache,
            userCoinLocalDataSource = local
        )
    }


    /*
        Use Cases
     */

    @Provides
    fun provideSortCoinsUseCase(): SortCoinListUseCase {
        return SortCoinListUseCase()
    }

    @Provides
    fun provideSearchCoinUseCase(): SearchCoinUseCase {
        return SearchCoinUseCase()
    }


}