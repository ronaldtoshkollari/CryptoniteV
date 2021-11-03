package com.example.cryptonite.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cryptonite.domain.model.Coin


@Dao
interface CoinDao {

    @Query("SELECT * FROM coins")
    suspend fun getCoins(): List<Coin>


    @Query("SELECT * FROM coins WHERE id = :id")
    suspend fun getCoinById(id: String): Coin

    @Query("SELECT * FROM coins WHERE name = :name")
    suspend fun getCoinByName(name: String): Coin


    @Insert
    suspend fun insertCoins(coins: List<Coin>)

    @Query("DELETE FROM coins")
    suspend fun clearAll()

}