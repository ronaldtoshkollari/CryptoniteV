package com.example.cryptonite.data.db.coin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptonite.domain.model.coin.Coin


@Dao
interface CoinDao {

    @Query("SELECT * FROM coins")
    suspend fun getCoins(): List<Coin>


    @Query("SELECT * FROM coins WHERE id = :id")
    suspend fun getCoinById(id: String): Coin

    @Query("SELECT * FROM coins WHERE name = :name")
    suspend fun getCoinByName(name: String): Coin


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoins(coins: List<Coin>)

    @Query("DELETE FROM coins")
    suspend fun clearAll()

}