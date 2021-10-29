package com.example.cryptonite.presentation.main_screen.components.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptonite.R
import com.example.cryptonite.presentation.main_screen.components.home_screen.coin_list.CoinList
import com.example.cryptonite.presentation.main_screen.components.home_screen.info_card.CardInfo
import com.example.cryptonite.presentation.main_screen.components.home_screen.sort_list.SortList
import com.example.cryptonite.presentation.view_model.home_screen_view_model.CoinListViewModel


@Composable
fun HomeScreen(

    viewModel: CoinListViewModel = hiltViewModel()

) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        
        Spacer(modifier = Modifier.height(14.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            
            Spacer(modifier = Modifier.width(10.dp))
            
            Text(
                text = "Crypto Wallet",
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.width(10.dp))

            Image(
                painter = painterResource(id = R.drawable.crypto),
                contentDescription = "crypto_img",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        CardInfo()


        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Market",
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        SortList()

        val state = viewModel.state.value

        CoinList(state.coins)



        
        

    }

}