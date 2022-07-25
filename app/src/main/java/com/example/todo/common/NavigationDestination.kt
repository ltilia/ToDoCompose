package com.example.todo.common

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavOptionsBuilder

interface NavigationDestination {
    val destination: String
    val argument: List<NamedNavArgument>
    fun configureNavOptions(option: NavOptionsBuilder)
}
