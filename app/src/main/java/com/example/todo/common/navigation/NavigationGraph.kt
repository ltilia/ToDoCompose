package com.example.todo.common.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.todo.common.navigation.destinations.TodoItemDestination
import com.example.todo.common.navigation.destinations.TodoListDestination
import com.example.todo.presnation.todo_item.component.TodoScreen
import com.example.todo.presnation.todo_list.component.ToDoListScreen

fun NavGraphBuilder.addToDoItem() {
    composable(
        route = TodoItemDestination.createDestination().destination,
        arguments = TodoItemDestination.createDestination().argument
    ) {
        TodoScreen()
    }
}

fun NavGraphBuilder.addToDoList() {
    composable(route = TodoListDestination.destination) {
        ToDoListScreen()
    }
}
