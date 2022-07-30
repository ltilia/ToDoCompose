package com.example.todo.common.navigation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.example.todo.common.navigation.NavigationManager

@Composable
fun Navigator(navHostController: NavHostController) {
    val command = NavigationManager.state.collectAsState().value
    LaunchedEffect(command) {
        when (command) {
            is NavigationManager.Command.Navigate -> {
                navHostController.navigate(command.destination.destination)
            }

            is NavigationManager.Command.PopBackStack -> {
                navHostController.popBackStack()
            }
        }
    }
}
