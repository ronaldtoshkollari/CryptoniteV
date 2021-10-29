package com.example.cryptonite.presentation.main_screen.components.home_screen.sort_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun SortList() { //TODO: Add sort List

    val tags = listOf("All", "Market Cap", "Price", "Price Change", "A-Z", "Max Supply", "Total Supply")

    LazyRow(contentPadding = PaddingValues(all = 6.dp),
    horizontalArrangement = Arrangement.spacedBy(3.dp)) {

        //TODO: Add sort compose
        items(tags){ tag ->
            SortItem(tagName = tag)
        }

    }

}