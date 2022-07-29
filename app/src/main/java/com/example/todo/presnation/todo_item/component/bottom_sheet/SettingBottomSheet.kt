package com.example.todo.presnation.todo_item.component.bottom_sheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import com.example.todo.R

@Composable
fun SettingBottomSheet(selectedColor: MutableState<Color>, onColorChanged: (Int) -> Unit) {
    BottomSheenItem(iconResId = R.drawable.delete, titleResId = R.string.delete)
    BottomSheenItem(iconResId = R.drawable.copy, titleResId = R.string.make_copy)
    BottomSheenItem(iconResId = R.drawable.share, titleResId = R.string.send)
    BottomSheenItem(iconResId = R.drawable.add_user, titleResId = R.string.collaborator)
    BottomSheenItem(iconResId = R.drawable.tag, titleResId = R.string.label)

    ColorsList(selectedColor, onColorChanged)
}
