package com.example.cryptonite.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cryptonite.data.db.coin.CoinDao
import com.example.cryptonite.data.db.user_coin.UserCoinDao
import com.example.cryptonite.domain.model.coin.Coin
import com.example.cryptonite.domain.model.user_coin.UserCoin

@Database(version = 2, entities = [(Coin::class), (UserCoin::class)], exportSchema = false)
abstract class CryptoniteDatabase : RoomDatabase() {

    abstract fun coinDao(): CoinDao
    abstract fun userCoinDao(): UserCoinDao

}