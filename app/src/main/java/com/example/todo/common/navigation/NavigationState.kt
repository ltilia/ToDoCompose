package com.example.todo.common.navigation

import com.example.todo.common.NavigationDestination

data class NavigationState(
    val navigationDestination: NavigationDestination,
    val command: Command
)

enum class Command {
    NAVIGATE,
    POP_BACK_STACK
}
