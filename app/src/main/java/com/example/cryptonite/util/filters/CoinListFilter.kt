package com.example.cryptonite.util.filters

sealed class CoinListFilter(val orderType: OrderType? = null){

    class All: CoinListFilter()
    class MarketCap(orderType: OrderType): CoinListFilter(orderType)
    class Price(orderType: OrderType): CoinListFilter(orderType)
    class PriceChange(orderType: OrderType): CoinListFilter(orderType)
    class Alphabetical(orderType: OrderType): CoinListFilter(orderType)
    class MaxSupply(orderType: OrderType): CoinListFilter(orderType)
    class TotalSupply(orderType: OrderType): CoinListFilter(orderType)
}
