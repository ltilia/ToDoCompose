package com.example.todo.presnation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todo.presnation.todo_item.component.TodoScreen
import com.example.todo.presnation.todo_list.component.ToDoListScreen
import com.example.todo.presnation.ui.theme.ToDoTheme
import com.example.todo.presnation.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ToDoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.TodoListScreen.route
                    ) {
                        composable(route = Screen.TodoListScreen.route) {
                            ToDoListScreen(onItemClicked = { id ->
                                navController.navigate(Screen.TodoItem.route + "?id=$id")
                            }, onAddNewToDo = {
                                    navController.navigate(Screen.TodoItem.route)
                                })
                        }

                        composable(
                            route = Screen.TodoItem.route + "?id={id}",
                            listOf(
                                navArgument("id") {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )
                        ) {
                            TodoScreen(navController)
                        }
                    }
                }
            }
        }
    }
}