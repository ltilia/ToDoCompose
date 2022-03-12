package com.example.todo.presnation.todo_item.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomSheenItem(iconResId: Int, titleResId: Int) {
    Row(
        modifier = Modifier.padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter =  painterResource(id = iconResId),
            contentDescription = stringResource(id = titleResId),
            tint = Color.White
        )
        Text(
            text = stringResource(id = titleResId),
            color = Color.White,
            fontSize = 16.sp
        )
    }
}