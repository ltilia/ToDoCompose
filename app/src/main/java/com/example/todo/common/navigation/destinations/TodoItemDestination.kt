package com.example.todo.common.navigation.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.todo.common.NavigationDestination
import com.example.todo.domain.Todo
import com.example.todo.presnation.util.toJson

open class TodoItemDestination : NavigationDestination {
    companion object {
        private const val ROUTE = "TodoItem"
        const val TODO_ITEM = "Item"
        private const val ROUTE_WITH_ARG = "$ROUTE?$TODO_ITEM={$TODO_ITEM}"

        fun createDestination(todo: Todo): NavigationDestination {
            return object : TodoItemDestination() {
                override val destination: String
                    get() = "$ROUTE?$TODO_ITEM=${todo.toJson()}"
            }
        }

        fun createDestination(): NavigationDestination {
            return TodoItemDestination()
        }
    }

    override val destination: String
        get() = ROUTE_WITH_ARG

    override val argument: List<NamedNavArgument>
        get() = listOf(
            navArgument(TODO_ITEM, builder = {
                type = NavType.StringType
                defaultValue = ""
            })
        )

    override fun configureNavOptions(option: NavOptionsBuilder) {
        option.apply {
            popUpTo(TodoListDestination.destination)
        }
    }
}
