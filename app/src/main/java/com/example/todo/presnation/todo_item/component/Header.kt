package com.example.todo.presnation.todo_item.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.R
import com.example.todo.ui.theme.DARK_GREEN

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(DARK_GREEN)
            .padding(horizontal = 5.dp)
            .padding(top = 25.dp, bottom = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.align(Alignment.CenterStart)) {
            Icon(
                modifier = Modifier.size(22.dp),
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "Back",
                tint = Color.White
            )
        }

        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.archive),
                    contentDescription = "Add to archive",
                    tint = Color.White
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "Add reminder",
                    tint = Color.White
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.pin),
                    contentDescription = "Pin",
                    tint = Color.White
                )
            }
        }
    }
}