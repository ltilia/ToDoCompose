package com.example.todo.presnation.todo_item.component.bottom_sheet

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todo.presnation.todo_item.component.bottom_sheet.ColorItem
import com.example.todo.presnation.todo_item.util.ColorsUtil

@Composable
fun ColorsList() {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(ColorsUtil.todoItemColors) { color ->
            ColorItem(color)
        }
    }
}