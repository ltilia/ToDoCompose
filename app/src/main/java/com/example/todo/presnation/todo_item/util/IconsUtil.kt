package com.example.todo.presnation.todo_item.util

import android.view.View
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.LayoutDirection
import androidx.core.text.layoutDirection
import java.util.*

fun Modifier.mirro(): Modifier {
    if (Locale.getDefault().layoutDirection == View.LAYOUT_DIRECTION_RTL) {
        return this.scale(scaleX = -1f, scaleY = 1f)
    }
    return this
}