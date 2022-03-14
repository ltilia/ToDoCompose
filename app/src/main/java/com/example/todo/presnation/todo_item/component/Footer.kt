package com.example.todo.presnation.todo_item.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.presnation.todo_item.component.bottom_sheet.BottomSheetType
import com.example.todo.presnation.ui.theme.DARK_GREEN

@Composable
fun Footer(
    color: Color,
    showMoreContent: (BottomSheetType) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().background(color),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = {
            showMoreContent(BottomSheetType.Setting)
        }) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Menu",
                tint = Color.White
            )
        }

        Text(text = "Last update 6:00 PM", color = Color.White, fontSize = 14.sp)

        IconButton(onClick = {
            showMoreContent(BottomSheetType.MoreContent)
        }) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .border(width = 2.dp, color = Color.White),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        }
    }
}