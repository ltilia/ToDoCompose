package com.example.todo.presnation.todo_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
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
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .background(DARK_GRAY_100)
                .padding(top = 40.dp)
        ) {
            Header()
            ToDoList(Modifier.weight(1f), state.todoList, onItemClicked = { todo ->
                viewModel.navigate(TodoItemDestination.createDestination(todo))
            })

            TodoListSetting(onAddNewTodoEvent = {
                viewModel.navigate(TodoItemDestination.createDestination())
            })
        }
    }
}
