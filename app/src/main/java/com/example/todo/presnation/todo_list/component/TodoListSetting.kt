package com.example.todo.presnation.todo_list.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.todo.R
import com.example.todo.presnation.ui.theme.DARK_GRAY
import com.example.todo.presnation.ui.theme.DARK_ORANGE

@Composable
fun TodoListSetting(onAddNewTodoEvent: () -> Unit) {
    Box(
        modifier = Modifier.height(80.dp).background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        val paddingTest = 80f

        Canvas(modifier = Modifier.fillMaxSize().background(Color.Transparent)) {
            val path = Path().apply {
                arcTo(
                    Rect(
                        center = Offset(size.width / 2 + 150, paddingTest), 80f
                    ),
                    180f, -180f, false
                )
                lineTo(size.width, paddingTest)
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                lineTo(0f, paddingTest)
            }

            drawPath(
                path = path,
                brush = SolidColor(DARK_GRAY)
            )
        }

        Row(
            Modifier
                .align(Alignment.BottomEnd)
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(
                    id = R.drawable.checkbox,
                ),
                contentDescription = "checkbox",
                tint = Color.White
            )

            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(
                    id = R.drawable.brush
                ),
                contentDescription = "Brush",
                tint = Color.White
            )

            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(
                    id = R.drawable.mic
                ),
                contentDescription = "Mic",
                tint = Color.White
            )

            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(
                    id = R.drawable.gallery
                ),
                contentDescription = "Gallery",
                tint = Color.White
            )
        }

        Box(
            modifier = Modifier.padding(start = 114.dp, bottom = 20.dp)
                .size(55.dp).clip(CircleShape)
                .background(DARK_GRAY).clickable {
                    onAddNewTodoEvent()
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = Icons.Default.Add, contentDescription = "Add", tint = DARK_ORANGE
            )
        }
    }
}
