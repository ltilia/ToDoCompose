package com.example.todo.presnation.todo_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.todo.presnation.ui.theme.DARK_GRAY
import com.example.todo.presnation.ui.theme.DARK_ORANGE

@Composable
fun AddFloatingActionButton(modifier: Modifier, onAddNewToDo: () -> Unit) {
    IconButton(
        modifier = modifier
            .padding(horizontal = 40.dp, vertical = 120.dp)
            .size(60.dp)
            .shadow(elevation = 7.dp, shape = CircleShape)
            .clip(CircleShape)
            .background(DARK_GRAY),
        onClick = {
            onAddNewToDo()
        }
    ) {
        Icon(
            modifier = Modifier.size(40.dp),
            imageVector = Icons.Default.Add,
            contentDescription = "",
            tint = DARK_ORANGE
        )
    }
}