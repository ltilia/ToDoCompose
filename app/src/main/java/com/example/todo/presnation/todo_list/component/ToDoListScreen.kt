package com.example.todo.presnation.todo_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.common.navigation.destinations.TodoItemDestination
import com.example.todo.presnation.todo_list.TodoListViewModel
import com.example.todo.presnation.ui.theme.DARK_GRAY_100

@Composable
fun ToDoListScreen(
    viewModel: TodoListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DARK_GRAY_100)
    ) {
        Column(
            modifier = Modifier
                .background(DARK_GRAY_100)
                .padding(vertical = 40.dp, horizontal = 5.dp)
        ) {
            Header()
            ToDoList(state.todoList, onItemClicked = { todo ->
                viewModel.navigate(TodoItemDestination.createDestination(todo))
            })
        }

        AddFloatingActionButton(Modifier.align(Alignment.BottomEnd), onAddNewToDo = {
            viewModel.navigate(TodoItemDestination.createDestination())
        })
    }
}
