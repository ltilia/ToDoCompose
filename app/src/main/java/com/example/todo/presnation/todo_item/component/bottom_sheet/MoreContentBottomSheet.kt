package com.example.todo.presnation.todo_item.component.bottom_sheet

import androidx.compose.runtime.Composable
import com.example.todo.R
import com.example.todo.presnation.todo_item.component.BottomSheenItem

@Composable
fun MoreContentBottomSheet() {
    BottomSheenItem(iconResId = R.drawable.camera, titleResId = R.string.take_photo)
    BottomSheenItem(iconResId = R.drawable.gallery, titleResId = R.string.choose_image)
    BottomSheenItem(iconResId = R.drawable.brush, titleResId = R.string.drawing)
    BottomSheenItem(iconResId = R.drawable.mic, titleResId = R.string.recording)
    BottomSheenItem(iconResId = R.drawable.checkbox, titleResId = R.string.check_box)
}