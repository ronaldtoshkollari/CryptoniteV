package com.example.cryptonite.domain.model.user_coin

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_coins")
data class UserCoin(
    val name: String,
    val image: String,
    @PrimaryKey
    val id: String,
    val userAmount: Double,
    val coinPrice: Double,
    val coinPriceChangePercentage: Double,
    val coinPriceChange: Double
)
