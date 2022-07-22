package com.example.todo.presnation.todo_item

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.domain.Todo
import com.example.todo.domain.use_case.GetToDoUseCase
import com.example.todo.domain.use_case.InsertTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TodoItemViewModel @Inject constructor(
    private val insertTodoUseCase: InsertTodoUseCase,
    private val getToDoUseCase: GetToDoUseCase,
    savedStateHandle: SavedStateHandle
    ): ViewModel() {

    private var _state: MutableState<TodoItemState> = mutableStateOf(TodoItemState())
    val state: State<TodoItemState>
    get() = _state
    init {
        savedStateHandle.get<String>("id")?.let { id ->
            if (id.isNotBlank()) {
                viewModelScope.launch {
                    getToDoUseCase.invoke(id).collect { todo ->
                        _state.value.id = todo.id.toString()
                        _state.value.title = todo.title
                        _state.value.content = todo.content
                        _state.value.color = todo.color
                    }
                }
            }
        }
    }

    fun onEvent(event: TodoScreenEvent) {
        when(event) {
            is TodoScreenEvent.OnTitleChange -> {
                _state.value = _state.value.copy(title = event.title)
            }

            is TodoScreenEvent.OnContentChange -> {
                _state.value = _state.value.copy(content = event.content)
            }

            is TodoScreenEvent.OnColorChange -> {
                _state.value = _state.value.copy(color = event.color)
            }

            is TodoScreenEvent.OnBackButtonPressed -> {
                insertTodo(Todo(
                    title = _state.value.title ?: "",
                    content = _state.value.content ?: "",
                    color = _state.value.color,
                    id = if (!_state.value.id.isNullOrBlank()) {
                        UUID.fromString(_state.value.id)
                    } else {
                        UUID.randomUUID()
                    }
                ))
            }
        }
    }

    private fun insertTodo(todo: Todo) {
        viewModelScope.launch {
            insertTodoUseCase.invoke(todo)
        }
    }

    sealed class TodoScreenEvent {
        data class OnTitleChange(val title: String): TodoScreenEvent()
        data class OnContentChange(val content: String): TodoScreenEvent()
        data class OnColorChange(val color: Int): TodoScreenEvent()
        object OnBackButtonPressed: TodoScreenEvent()
    }
}