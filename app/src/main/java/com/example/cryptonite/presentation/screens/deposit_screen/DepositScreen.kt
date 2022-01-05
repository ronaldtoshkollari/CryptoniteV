package com.example.cryptonite.presentation.screens.deposit_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptonite.R
import com.example.cryptonite.presentation.screens.deposit_screen.viewmodel.DepositScreenEvent
import com.example.cryptonite.presentation.screens.deposit_screen.widgets.DefaultButton
import com.example.cryptonite.presentation.screens.deposit_screen.widgets.DefaultDropdownMenu
import com.example.cryptonite.presentation.screens.deposit_screen.widgets.DefaultEditText
import com.example.cryptonite.presentation.screens.deposit_screen.widgets.WalletCoinItem
import com.example.cryptonite.presentation.screens.deposit_screen.viewmodel.DepositViewModel


@Composable
fun DepositScreen(
    viewModel: DepositViewModel = hiltViewModel()
) {


    val openAlertDialog = remember {
        mutableStateOf(false)
    }

    val state = viewModel.state.value

    Box {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(imageVector = Icons.Filled.ArrowBack, contentDescription = "arrow_back")

                Text(
                    text = "Total Balance",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 20.sp
                )

                Image(imageVector = Icons.Filled.Person, contentDescription = "person_icon")

            }

            Spacer(modifier = Modifier.height(80.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = state.userTotalAmount.toString(),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 40.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Spacer(modifier = Modifier.width(5.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_up),
                    contentDescription = "arrow_up"
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {


                Text(
                    text = "$726(15%)today",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light,
                    color = Color.Green
                )

            }

            Spacer(modifier = Modifier.height(35.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        MaterialTheme.colors.secondary,
                        shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                    )
                    .padding(horizontal = 15.dp, vertical = 15.dp)
            ) {

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Crypto Wallet",
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.onSecondary,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                LazyColumn(
                    contentPadding = PaddingValues(
                        start = 3.dp,
                        end = 3.dp,
                        top = 6.dp,
                        bottom = 6.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(items = state.userCoins) {
                        WalletCoinItem(it)
                    }

                }

            }


        }


        FloatingActionButton(
            onClick = {
                openAlertDialog.value = true
                Log.i("FAB", "DepositScreen: Clicked")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(18.dp),
            backgroundColor = Color.White
        ) {

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "ic_add",
                tint = MaterialTheme.colors.secondary
            )

        }


        if (openAlertDialog.value) {

            AlertDialog(onDismissRequest = { openAlertDialog.value = false },
                buttons = {
                    Row {
                        DefaultButton(text = "Add") {
                            openAlertDialog.value = false
                            if(state.userCoin != null && state.coinToBeAddedAmount > 0.0){




                                viewModel.onEvent(DepositScreenEvent.AddCoin(state.userCoin))
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp),
                shape = RoundedCornerShape(24.dp),
                text = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Text(
                            text = "Add your coin",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colors.primary,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        DefaultEditText {
                            state.coinToBeAddedAmount = it
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Log.e("DEPOSITSCREEN", "Error: ${state.allCoins}", )
                        DefaultDropdownMenu(items = state.allCoins) {
                            state.coin = it
                        }

                    }
                }

            )


        }
    }


}