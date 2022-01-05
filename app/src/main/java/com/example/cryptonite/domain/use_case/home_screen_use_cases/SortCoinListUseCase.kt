package com.example.cryptonite.domain.use_case.home_screen_use_cases

import com.example.cryptonite.domain.model.coin.Coin
import com.example.cryptonite.util.filters.CoinListFilter
import com.example.cryptonite.util.filters.OrderType


class SortCoinListUseCase {


    operator fun invoke(coinList: List<Coin>,
                        coinListFiler: CoinListFilter = CoinListFilter.All()): List<Coin> {

        when (coinListFiler) {


            is CoinListFilter.All -> {
                return coinList.sortedByDescending { it.market_cap?.toDouble() }
            }

            is CoinListFilter.MarketCap -> {

                when(coinListFiler.orderType){

                    is OrderType.Descending -> {
                        return coinList.sortedByDescending { it.market_cap?.toDouble() }
                    }

                    is OrderType.Ascending -> {
                        return coinList.sortedBy { it.market_cap?.toDouble() }
                    }
                }

            }

            is CoinListFilter.Alphabetical -> {

                when(coinListFiler.orderType){

                    is OrderType.Descending -> {
                        return coinList.sortedByDescending { it.name?.lowercase() }
                    }

                    is OrderType.Ascending -> {
                        return coinList.sortedBy { it.name?.lowercase() }
                    }
                }

            }

            is CoinListFilter.Price -> {

                when(coinListFiler.orderType){

                    is OrderType.Descending -> {
                        return coinList.sortedByDescending { it.current_price?.toDouble() }

                    }

                    is OrderType.Ascending -> {
                        return coinList.sortedBy { it.current_price?.toDouble() }

                    }
                }

            }

            is CoinListFilter.PriceChange -> {

                when(coinListFiler.orderType){

                    is OrderType.Descending -> {
                        return coinList.sortedByDescending { it.price_change_percentage_24h }
                    }

                    is OrderType.Ascending -> {
                        return coinList.sortedBy { it.price_change_percentage_24h }
                    }
                }

            }

            is CoinListFilter.MaxSupply -> {

                when(coinListFiler.orderType){

                    is OrderType.Descending -> {
                        return coinList.sortedByDescending { it.max_supply?.toDouble() }
                    }

                    is OrderType.Ascending -> {
                        return coinList.sortedBy { it.max_supply?.toDouble() }
                    }
                }

            }

            is CoinListFilter.TotalSupply -> {

                when(coinListFiler.orderType){

                    is OrderType.Descending -> {
                        return coinList.sortedByDescending { it.total_supply?.toDouble() }
                    }

                    is OrderType.Ascending -> {
                        return coinList.sortedBy { it.total_supply?.toDouble() }

                    }
                }

            }


        }

        return coinList


    }

}