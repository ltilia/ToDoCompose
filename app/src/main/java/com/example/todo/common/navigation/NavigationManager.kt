package com.example.todo.common.navigation

import com.example.todo.common.NavigationDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object NavigationManager {
    private val _state: MutableStateFlow<Command?> = MutableStateFlow(null)
    val state: StateFlow<Command?>
        get() = _state

    fun navigate(destination: NavigationDestination) {
        _state.value = Command.Navigate(destination)
    }

    fun popBackStack() {
        _state.value = Command.PopBackStack
    }

    sealed class Command {
        data class Navigate(val destination: NavigationDestination) : Command()
        object PopBackStack : Command()
    }
}
