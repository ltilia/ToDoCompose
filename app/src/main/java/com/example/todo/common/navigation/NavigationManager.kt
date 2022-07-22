package com.example.todo.common.navigation

import com.example.todo.common.NavigationDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object NavigationManager {
    private val _state: MutableStateFlow<NavigationState?> = MutableStateFlow(null)
    val state: StateFlow<NavigationState?>
        get() = _state

    fun navigate(destination: NavigationDestination) {
        _state.value = NavigationState(destination, Command.NAVIGATE)
    }

    fun popBackStack(destination: NavigationDestination) {
        _state.value = NavigationState(destination, Command.POP_BACK_STACK)
    }
}
