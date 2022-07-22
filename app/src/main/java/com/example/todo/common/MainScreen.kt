package com.example.todo.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.todo.common.navigation.Command
import com.example.todo.common.navigation.NavigationManager
import com.example.todo.common.navigation.addToDoItem
import com.example.todo.common.navigation.addToDoList
import com.example.todo.common.navigation.destinations.TodoListDestination
import com.example.todo.presnation.ui.theme.ToDoTheme

@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    val navigationState = NavigationManager.state.collectAsState().value

    ToDoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NavHost(
                navController = navHostController,
                startDestination = TodoListDestination.destination
            ) {
                addToDoList()
                addToDoItem()
            }
        }
    }

    LaunchedEffect(navigationState?.navigationDestination?.destination) {
        navigationState?.navigationDestination?.let {
            when (navigationState.command) {
                Command.NAVIGATE -> {
                    navHostController.navigate(navigationState.navigationDestination.destination, builder = {
                        navigationState.navigationDestination.configureNavOptions(this)
                    })
                }

                Command.POP_BACK_STACK -> {
                    navHostController
                        .popBackStack(navigationState.navigationDestination.destination, false)
                }
            }
        }
    }
}
