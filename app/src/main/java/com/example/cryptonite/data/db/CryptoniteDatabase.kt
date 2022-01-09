package com.example.cryptonite.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cryptonite.data.db.coin.CoinDao
import com.example.cryptonite.domain.model.coin.Coin

@Database(version = 2, entities = [(Coin::class)], exportSchema = false)
abstract class CryptoniteDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
}