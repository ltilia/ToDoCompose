package com.example.todo.presnation.todo_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.presnation.ui.theme.DARK_GRAY_100

@Composable
fun ToDoListScreen(onItemClicked: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(DARK_GRAY_100)) {
        Column(
            modifier = Modifier
                .background(DARK_GRAY_100)
                .padding(vertical = 40.dp, horizontal = 5.dp)) {
            Header()
            ToDoList(onItemClicked)
        }
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}