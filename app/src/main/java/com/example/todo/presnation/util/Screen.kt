package com.example.todo.presnation.util

sealed class Screen(val route: String) {
    object TodoListScreen: Screen("TodoList")
    object TodoItem: Screen("TodoItem")
}
