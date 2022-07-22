package com.example.todo.data.repository

import com.example.todo.data.local_data_source.TodoDao
import com.example.todo.domain.Todo
import com.example.todo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(private val dao: TodoDao) : TodoRepository {
    override suspend fun insertTodo(todo: Todo) = dao.insertTodo(todo)

    override suspend fun deleteTodo(todo: Todo) {
        TODO("Not yet implemented")
    }

    override fun getTodo(id: String): Flow<Todo> = dao.getTodo(id)

    override fun getTodoList(): Flow<List<Todo>> = dao.getAllTodo()
}
