package com.example.cryptonite.util.filters

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
