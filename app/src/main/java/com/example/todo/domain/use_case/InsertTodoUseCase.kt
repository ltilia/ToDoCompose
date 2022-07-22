package com.example.todo.domain.use_case

import com.example.todo.domain.Todo
import com.example.todo.domain.repository.TodoRepository
import javax.inject.Inject

class InsertTodoUseCase @Inject constructor(private val repository: TodoRepository) {

    suspend operator fun invoke(todo: Todo) {
        if (todo.title.isBlank() && todo.content.isBlank()) {
            return
        }

        repository.insertTodo(todo)
    }
}
