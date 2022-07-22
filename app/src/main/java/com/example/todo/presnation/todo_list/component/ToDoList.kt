package com.example.todo.presnation.todo_list.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todo.domain.Todo
import com.nesyou.staggeredgrid.LazyStaggeredGrid
import com.nesyou.staggeredgrid.StaggeredCells

@Composable
fun ToDoList(todoList: List<Todo>, onItemClicked: (todo: Todo) -> Unit) {
    LazyStaggeredGrid(
        modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
        cells = StaggeredCells.Fixed(2)
    ) {
        items(todoList) { todoItem ->
            ToDoItem(todoItem, onItemClicked)
        }
    }
}
