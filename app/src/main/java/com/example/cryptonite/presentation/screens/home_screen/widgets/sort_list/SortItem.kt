package com.example.cryptonite.presentation.screens.home_screen.widgets.sort_list

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun SortItem(
    tagName: String,
    onSortClick: () -> Unit,
    isDescending: Boolean,
    showArrow: Boolean,
    isSelected: Boolean
) {

    Surface(
        modifier = Modifier
            .padding(5.dp)
            .height(48.dp)
            .clickable { onSortClick() }
            .clip(RoundedCornerShape(CornerSize(32.dp))),
        color = MaterialTheme.colors.surface,
        border = if (isSelected) BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colors.onBackground
        ) else null,
        shape = RoundedCornerShape(CornerSize(32.dp)),
        elevation = 2.dp
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = tagName,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(15.dp),
                style = MaterialTheme.typography.button
            )

            Spacer(modifier = Modifier.width(3.dp))


            if (showArrow)
                Icon(
                    imageVector = if (isDescending) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = "sort_direction",
                    modifier = Modifier.padding(end = 5.dp)
                )

        }


    }


}