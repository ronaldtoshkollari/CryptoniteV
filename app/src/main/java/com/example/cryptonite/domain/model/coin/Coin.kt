package com.example.cryptonite.domain.model.coin

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "coins")
data class Coin(
    val ath: String? = "", //all time high price
    val ath_change_percentage: Double? = 0.0,
    val ath_date: String? = "",
    val atl: String? = "", //all time low price
    val atl_change_percentage: Double? = 0.0,
    val atl_date: String? = "",
    val circulating_supply: String? = "", // the number of cryptocurrency coins or tokens that are publicly available and circulating in the market
    val current_price: String? = "",
    val fully_diluted_valuation: String? = "", //  total value of the crypto at today's price if the entire future supply of coins were in circulation
    val high_24h: String? = "", // max price in one day
    @PrimaryKey
    val id: String = "",
    val image: String? = "",
    val last_updated: String? = "",
    val low_24h: String? = "",
    val market_cap: String? = "",
    val market_cap_change_24h: String? = "",
    val market_cap_change_percentage_24h: Double? = 0.0,
    val market_cap_rank: Int? = 0,
    val max_supply: String? = "", //Total number of coins that can be mined
    val name: String = "",
    val price_change_24h: String? = "",
    val price_change_percentage_24h: Double? = 0.0,
    val symbol: String? = "",
    val total_supply: String? = "", //the total amount of coins in existence right now (minus any coins that have been verifiably burned)
    val total_volume: String? = "" //the sum total of actual trades taking place
)
