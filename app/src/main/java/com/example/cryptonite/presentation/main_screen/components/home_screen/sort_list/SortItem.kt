package com.example.cryptonite.presentation.main_screen.components.home_screen.sort_list

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptonite.R


@Composable
fun SortItem(
    tagName: String,
    onSortClick: () -> Unit,
    isDescending: Boolean,
    showArrow: Boolean,
    isSelected: Boolean
) {


    Row(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(32.dp))
            .clickable { onSortClick() }
            .border(
                width = if(isSelected) 2.dp else 0.dp,
                shape = RoundedCornerShape(32.dp),
                color = MaterialTheme.colors.onBackground
            )
            .background(MaterialTheme.colors.surface),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

        ) {
        Text(
            text = tagName,
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(15.dp),
            fontWeight = FontWeight.Light,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.width(3.dp))

        if (showArrow)
            Image(
               imageVector = if (isDescending) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore, contentDescription = "sort_direction",
                modifier = Modifier.padding(end = 5.dp)
            )

    }

}