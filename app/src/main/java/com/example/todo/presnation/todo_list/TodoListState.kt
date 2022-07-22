package com.example.todo.presnation.todo_list

import com.example.todo.domain.Todo

data class TodoListState(
    val todoList: List<Todo> = emptyList()
)
