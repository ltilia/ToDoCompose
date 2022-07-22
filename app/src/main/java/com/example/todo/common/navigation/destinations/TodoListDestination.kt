package com.example.todo.common.navigation.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavOptionsBuilder
import com.example.todo.common.NavigationDestination

object TodoListDestination : NavigationDestination {
    private const val ROUTE = "TodoList"
    override val destination: String
        get() = ROUTE
    override val argument: List<NamedNavArgument>
        get() = emptyList()

    override fun configureNavOptions(option: NavOptionsBuilder) {
        option.apply {
            popUpTo(0)
        }
    }
}
