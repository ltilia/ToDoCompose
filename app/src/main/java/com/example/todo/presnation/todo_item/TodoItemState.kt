package com.example.todo.presnation.todo_item

data class TodoItemState(
    var id: String? = null,
    var title: String? = null,
    var content: String? = null,
    var color: Int = -1
)
