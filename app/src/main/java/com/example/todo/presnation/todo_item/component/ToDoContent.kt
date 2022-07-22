package com.example.todo.presnation.todo_item.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.todo.presnation.todo_item.TodoItemState

@Composable
fun ToDoContent(
    modifier: Modifier,
    state: State<TodoItemState>,
    onTitleChanged: (String) -> Unit,
    onContentChanged: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color.Transparent)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = {
                Text(text = "The Title", color = Color.White, fontSize = 20.sp)
            },
            value = state.value.title ?: "",
            onValueChange = { value ->
                onTitleChanged(value)
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent
            ),
            textStyle = TextStyle(fontSize = 20.sp, color = Color.White)
        )
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth(),
            placeholder = {
                Text(text = "Note", color = Color.White, fontSize = 19.sp)
            },
            value = state.value.content ?: "",
            onValueChange = { value ->
                onContentChanged(value)
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                textColor = Color.White
            ),
            textStyle = TextStyle(fontSize = 19.sp, color = Color.White)
        )
    }
}
