package com.example.cryptonite.data.api.dto

import com.example.cryptonite.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinListDtoItem(
    val ath: String, //all time high price
    val ath_change_percentage: Double,
    val ath_date: String,
    val atl: String, //all time low price
    val atl_change_percentage: Double,
    val atl_date: String,
    val circulating_supply: String, // the number of cryptocurrency coins or tokens that are publicly available and circulating in the market
    val current_price: String,
    val fully_diluted_valuation: String, //  total value of the crypto at today's price if the entire future supply of coins were in circulation
    val high_24h: String, // max price in one day
    val id: String,
    val image: String,
    val last_updated: String,
    val low_24h: String,
    @SerializedName("market_cap")
    val market_cap: String,
    val market_cap_change_24h: String,
    val market_cap_change_percentage_24h: Double,
    val market_cap_rank: Int,
    val max_supply: String, //Total number of coins that can be mined
    val name: String,
    val price_change_24h: String,
    val price_change_percentage_24h: Double,
    val roi: Roi,
    val symbol: String,
    val total_supply: String, //the total amount of coins in existence right now (minus any coins that have been verifiably burned)
    val total_volume: String //the sum total of actual trades taking place
)

fun CoinListDtoItem.toCoin(): Coin {
    return Coin(
        ath= ath,
        ath_change_percentage = ath_change_percentage,
        ath_date = ath_date,
        atl = atl,
        atl_change_percentage = atl_change_percentage,
        atl_date = atl_date,
        circulating_supply = circulating_supply,
        current_price = current_price,
        fully_diluted_valuation = fully_diluted_valuation,
        high_24h = high_24h,
        id = id,
        image = image,
        last_updated = last_updated,
        low_24h = low_24h,
        market_cap = market_cap,
        market_cap_change_percentage_24h =  market_cap_change_percentage_24h,
        market_cap_change_24h = market_cap_change_24h,
        market_cap_rank = market_cap_rank,
        max_supply = max_supply,
        name = name,
        price_change_24h = price_change_24h,
        price_change_percentage_24h = price_change_percentage_24h,
        symbol = symbol,
        total_supply = total_supply,
        total_volume = total_volume
    )
}