package com.example.todo.presnation.todo_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.domain.Todo
import com.example.todo.presnation.ui.theme.DARK_GRAY

@Composable
fun ToDoItem(todo: Todo, onItemClicked: (String) -> Unit) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .defaultMinSize(minHeight = 70.dp, minWidth = 180.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(DARK_GRAY)
            .clickable {
                onItemClicked(todo.id.toString())
            }
            .border(width = 1.dp, color = Color.White.copy(.4f), shape = RoundedCornerShape(10.dp))
            .padding(vertical = 10.dp, horizontal = 5.dp)

    ) {
        Text(text = todo.title, color = Color.White)
        Text(text = todo.content, color = Color.White, fontSize = 11.sp)
    }
}
