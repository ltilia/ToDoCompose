package com.example.todo.presnation.todo_item.component.bottom_sheet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorModel
import androidx.compose.ui.graphics.colorspace.ColorSpace
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.dp
import com.example.todo.presnation.ui.theme.DARK_GREEN

@Composable
fun ColorItem(color: Color, selectedColor: MutableState<Color>) {
    Box(modifier = Modifier
        .padding(10.dp)
        .size(40.dp)
        .clip(CircleShape)
        .background(color)
        .border(
            width = 1.dp, color = color
                .copy(alpha = .8f)
                .compositeOver(Color.White), shape = CircleShape
        ).clickable {
            selectedColor.value = color
        },
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(visible = selectedColor.value == color) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "select color",
                tint = Color.White.copy(alpha = .5f)
            )
        }
    }
}