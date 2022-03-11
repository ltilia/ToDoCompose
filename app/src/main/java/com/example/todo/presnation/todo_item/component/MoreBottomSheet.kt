package com.example.todo.presnation.todo_item.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todo.R
import com.example.todo.ui.theme.DARK_GREEN

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MoreBottomSheet(
    bottomSheetState: ModalBottomSheetState, content: @Composable () -> Unit ) {
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(DARK_GREEN)) {
                BottomSheenItem(iconResId = R.drawable.camera, titleResId = R.string.take_photo)
                BottomSheenItem(iconResId = R.drawable.gallery, titleResId = R.string.choose_image)
                BottomSheenItem(iconResId = R.drawable.brush, titleResId = R.string.drawing)
                BottomSheenItem(iconResId = R.drawable.mic, titleResId = R.string.recording)
                BottomSheenItem(iconResId = R.drawable.checkbox, titleResId = R.string.check_box)
            }
        }, content = {
            content()
        }
    )
}