package com.example.todo.domain.repository

import com.example.todo.domain.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun insertTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
    fun getTodo(id: String): Flow<Todo>
    fun getTodoList(): Flow<List<Todo>>
}
