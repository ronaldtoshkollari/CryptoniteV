package com.example.cryptonite.presentation.screens.wallet_screen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cryptonite.presentation.screens.wallet_screen.viewmodel.WalletViewModel


@Composable
fun DepositScreen(
    viewModel: WalletViewModel = hiltViewModel(),
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                backgroundColor = MaterialTheme.colors.background,
                elevation = 10.dp,
                contentPadding = PaddingValues(4.dp)
            ) {

                Box(modifier = Modifier.fillMaxSize()) {

                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                        modifier = Modifier
                            .align(
                                Alignment.CenterStart
                            )
                            .clickable { navController.popBackStack() }
                    )

                    Text(
                        text = "Total Balance",
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.align(
                            Alignment.Center
                        )
                    )

                    Icon(imageVector = Icons.Default.Person,
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .align(
                                Alignment.CenterEnd
                            )
                            .clickable { navController.popBackStack() }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Coin",
                    tint = MaterialTheme.colors.onPrimary,
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxWidth()
                    .height(150.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(text = "$850.80", style = MaterialTheme.typography.h3)

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = "Arrow up"
                    )

                    Text(text = "$50(15%)today", style = MaterialTheme.typography.caption)

                }


            }

            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                color = MaterialTheme.colors.secondary
            ) {


            }

        }

    }
}

@Preview
@Composable
private fun PreviewDepositScreen() {
    DepositScreen(navController = rememberNavController())
}