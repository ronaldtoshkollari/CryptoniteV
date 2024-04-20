package com.example.cryptonite.presentation.screens.home_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.example.cryptonite.R
import com.example.cryptonite.presentation.components.bottom_nav_bar.BottomNavigationBar
import com.example.cryptonite.util.filters.CoinListFilter
import com.example.cryptonite.util.filters.OrderType
import com.example.cryptonite.presentation.screens.home_screen.viewmodel.HomeEvent
import com.example.cryptonite.presentation.screens.home_screen.widgets.coin_list.CoinList
import com.example.cryptonite.presentation.screens.home_screen.widgets.info_card.CardInfo
import com.example.cryptonite.presentation.screens.home_screen.widgets.sort_list.SortItem
import com.example.cryptonite.presentation.screens.home_screen.viewmodel.HomeViewModel
import com.example.cryptonite.util.filters.Filters


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {

    Scaffold(bottomBar = {
        BottomNavigationBar(navController)
    }) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colors.background)
        ) {

            val state = viewModel.state.value

            val focusManager = LocalFocusManager.current


            Spacer(modifier = Modifier.height(14.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Crypto Wallet",
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h4
                )

                Spacer(modifier = Modifier.width(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.crypto),
                    contentDescription = "crypto_img",
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            CardInfo(navController)


            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Market",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onBackground
            )


            Spacer(modifier = Modifier.height(4.dp))


            LazyRow(
                contentPadding = PaddingValues(all = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(3.dp)
            ) {

                items(state.filters) {filter ->

                    when (filter.name) {
                        Filters.All.name -> {

                            SortItem(
                                tagName = "All", onSortClick = {
                                    if (!state.isPriceDescending) {
                                        viewModel.onEvent(
                                            HomeEvent.Sort(
                                                CoinListFilter.Price(
                                                    OrderType.Descending
                                                )
                                            )
                                        )


                                    } else {
                                        viewModel.onEvent(HomeEvent.Sort(CoinListFilter.Price(OrderType.Ascending)))

                                    }
                                },
                                isDescending = state.isPriceDescending,
                                showArrow = true,
                                isSelected = state.isPriceTagSelected
                            )

                        }
                        Filters.PriceChange.name -> {
                            SortItem(
                                tagName = "Price Change", onSortClick = {
                                    if (!state.isPriceChangeDescending) {
                                        viewModel.onEvent(
                                            HomeEvent.Sort(
                                                CoinListFilter.PriceChange(
                                                    OrderType.Descending
                                                )
                                            )
                                        )


                                    } else {
                                        viewModel.onEvent(HomeEvent.Sort(CoinListFilter.PriceChange(OrderType.Ascending)))

                                    }
                                },
                                isDescending = state.isPriceChangeDescending,
                                showArrow = true,
                                isSelected = state.isPriceChangeTagSelected
                            )
                        }
                        Filters.MarketCap.name -> {
                            SortItem(
                                tagName = "Market Cap", onSortClick = {
                                    if (!state.isMarketCapDescending) {
                                        viewModel.onEvent(
                                            HomeEvent.Sort(
                                                CoinListFilter.MarketCap(
                                                    OrderType.Descending
                                                )
                                            )
                                        )

                                    } else {
                                        viewModel.onEvent(HomeEvent.Sort(CoinListFilter.MarketCap(OrderType.Ascending)))


                                    }
                                },
                                isDescending = state.isMarketCapDescending,
                                showArrow = true,
                                isSelected = state.isMarketCapTagSelected
                            )
                        }
                        Filters.Alphabetical.name -> {
                            SortItem(
                                tagName = "A-Z", onSortClick = {
                                    if (!state.isAlphabeticalDescending) {
                                        viewModel.onEvent(
                                            HomeEvent.Sort(
                                                CoinListFilter.Alphabetical(
                                                    OrderType.Descending
                                                )
                                            )
                                        )


                                    } else {
                                        viewModel.onEvent(HomeEvent.Sort(CoinListFilter.Alphabetical(OrderType.Ascending)))

                                    }
                                },
                                isDescending = state.isAlphabeticalDescending,
                                showArrow = true,
                                isSelected = state.isAlphabeticalTagSelected
                            )
                        }
                        Filters.MaxSupply.name -> {

                            SortItem(
                                tagName = "Max Supply", onSortClick = {
                                    if (!state.isMaxSupplyDescending) {
                                        viewModel.onEvent(
                                            HomeEvent.Sort(
                                                CoinListFilter.MaxSupply(
                                                    OrderType.Descending
                                                )
                                            )
                                        )


                                    } else {
                                        viewModel.onEvent(HomeEvent.Sort(CoinListFilter.MaxSupply(OrderType.Ascending)))

                                    }
                                },
                                isDescending = state.isMaxSupplyDescending,
                                showArrow = true,
                                isSelected = state.isMaxSupplyTagSelected
                            )

                        }
                        Filters.TotalSupply.name -> {

                            SortItem(
                                tagName = "Total Supply", onSortClick = {
                                    if (!state.isTotalSupplyDescending) {
                                        viewModel.onEvent(
                                            HomeEvent.Sort(
                                                CoinListFilter.TotalSupply(
                                                    OrderType.Descending
                                                )
                                            )
                                        )


                                    } else {
                                        viewModel.onEvent(HomeEvent.Sort(CoinListFilter.TotalSupply(OrderType.Ascending)))

                                    }
                                },
                                isDescending = state.isTotalSupplyDescending,
                                showArrow = true,
                                isSelected = state.isTotalSupplyTagSelected
                            )

                        }
                    }



                }



            }

            Spacer(modifier = Modifier.height(4.dp))

            TextField(
                value = viewModel.searchText.value,
                onValueChange = {
                    viewModel.onSearchText(it)
                    viewModel.onEvent(HomeEvent.SearchCoin(viewModel.searchText.value))
                },
                maxLines = 1,
                placeholder = {
                    Text(
                        text = "Search Coin...", color = Color.LightGray
                    )
                },
                trailingIcon = {
                    if (viewModel.searchText.value.isNotEmpty()) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "ic_close",
                            modifier = Modifier.clickable {
                                viewModel.onEvent(HomeEvent.SearchCoin(""))
                                viewModel.onSearchText("")
                                focusManager.clearFocus()
                            }
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "ic_search"
                        )
                    }
                },
                shape = RoundedCornerShape(100.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.onSurface,
                    backgroundColor = MaterialTheme.colors.surface,
                    placeholderColor = Color.LightGray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colors.onSurface
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(100.dp))
                    .shadow(8.dp, shape = RoundedCornerShape(100.dp)),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = { focusManager.clearFocus() }
                )
            )

            Spacer(modifier = Modifier.height(4.dp))


            CoinList(state.coins)

            if (state.isLoading) {
                val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.lottie_loading))
                val progress by animateLottieCompositionAsState(
                    composition,
                    iterations = LottieConstants.IterateForever
                )

                LottieAnimation(composition, progress, modifier = Modifier.fillMaxSize())
            }

            if (state.message.isNotEmpty()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.crypto_no_items_image),
                        contentDescription = "no_items_icon"
                    )

                }
            }


        }

    }



}