package com.example.cryptonite.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cryptonite.domain.model.Coin

@Database(version = 1, entities = [(Coin::class)])
abstract class CoinDatabase: RoomDatabase() {

    abstract fun coinDao(): CoinDao

}