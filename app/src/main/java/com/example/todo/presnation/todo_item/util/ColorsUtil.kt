package com.example.todo.presnation.todo_item.util

import androidx.compose.ui.graphics.Color
import com.example.todo.presnation.ui.theme.BLACK
import com.example.todo.presnation.ui.theme.BURGUNDY
import com.example.todo.presnation.ui.theme.DARK_BLUE
import com.example.todo.presnation.ui.theme.DARK_BROWN
import com.example.todo.presnation.ui.theme.DARK_GRAY
import com.example.todo.presnation.ui.theme.DARK_GREEN
import com.example.todo.presnation.ui.theme.DARK_GREEN_100
import com.example.todo.presnation.ui.theme.DARK_RED
import com.example.todo.presnation.ui.theme.DARK_YELLOW
import com.example.todo.presnation.ui.theme.DARK_YELLOW_100
import com.example.todo.presnation.ui.theme.PURPLE

object ColorsUtil {
    val todoItemColors = listOf(
        DARK_GRAY,
        DARK_BROWN,
        BURGUNDY,
        PURPLE,
        DARK_BLUE,
        DARK_YELLOW,
        DARK_YELLOW_100,
        DARK_RED,
        BLACK,
        DARK_GREEN,
        DARK_GREEN_100
    )

    fun getColorIndex(color: Color): Int {
        val index = todoItemColors.indexOf(color)
        if (index == -1) return 0
        return index
    }

    fun getColor(index: Int): Color {
        if (index in todoItemColors.indices) {
            return todoItemColors[index]
        }

        return todoItemColors.first()
    }
}
