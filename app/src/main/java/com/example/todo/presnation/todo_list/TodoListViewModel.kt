package com.example.todo.presnation.todo_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.common.NavigationDestination
import com.example.todo.common.navigation.NavigationManager
import com.example.todo.domain.use_case.GetTodoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val todoListUseCase: GetTodoListUseCase
) : ViewModel() {
    private val _state: MutableState<TodoListState> = mutableStateOf(TodoListState())
    val state: State<TodoListState>
        get() = _state

    init {
        loadTodoList()
    }

    private fun loadTodoList() {
        viewModelScope.launch {
            todoListUseCase.invoke().collect { todoList ->
                _state.value = TodoListState(todoList = todoList)
            }
        }
    }

    fun navigate(destination: NavigationDestination) {
        NavigationManager.navigate(destination)
    }
}
