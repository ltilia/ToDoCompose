package com.example.todo.presnation.todo_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.todo.R
import com.example.todo.presnation.ui.theme.DARK_GRAY
import com.example.todo.presnation.ui.theme.DARK_ORANGE

@Composable
fun Footer(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp),
        contentAlignment = Alignment.Center
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .fillMaxHeight(0.8f)
                .background(DARK_GRAY)
        )
        Row(
            Modifier
                .fillMaxHeight()
                .align(Alignment.CenterStart)
                .padding(start = 10.dp, bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(
                    id = R.drawable.checkbox,
                ),
                contentDescription = "checkbox",
                tint = Color.White
            )

            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(
                    id = R.drawable.brush
                ),
                contentDescription = "Brush",
                tint = Color.White
            )

            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(
                    id = R.drawable.mic
                ),
                contentDescription = "Mic",
                tint = Color.White
            )

            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(
                    id = R.drawable.gallery
                ),
                contentDescription = "Gallery",
                tint = Color.White
            )
        }

        IconButton(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .size(60.dp)
                 .shadow(elevation = 7.dp, shape = CircleShape)
                .clip(CircleShape)
                .background(DARK_GRAY)
                .align(Alignment.TopEnd),
             onClick = {}
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = DARK_ORANGE
            )
        }
    }
}