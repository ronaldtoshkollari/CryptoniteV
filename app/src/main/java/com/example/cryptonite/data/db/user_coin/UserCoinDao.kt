package com.example.cryptonite.data.db.user_coin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptonite.domain.model.user_coin.UserCoin


@Dao
interface UserCoinDao {

    @Query("SELECT * FROM user_coins")
    suspend fun getUserCoins(): List<UserCoin>

    @Query("DELETE FROM user_coins")
    suspend fun clearAll()

    @Query("DELETE FROM user_coins WHERE id = :id")
    suspend fun deleteCoinById(id: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoin(userCoin: UserCoin)


}