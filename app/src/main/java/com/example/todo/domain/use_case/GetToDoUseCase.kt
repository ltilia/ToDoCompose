package com.example.todo.domain.use_case

import com.example.todo.domain.repository.TodoRepository
import javax.inject.Inject

class GetToDoUseCase @Inject constructor(private val repository: TodoRepository) {

    operator fun invoke(id: String) = repository.getTodo(id)
}
