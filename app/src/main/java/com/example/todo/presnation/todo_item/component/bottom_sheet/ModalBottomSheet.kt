package com.example.todo.presnation.todo_item.component.bottom_sheet

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todo.presnation.todo_item.util.ColorsUtil

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheet(
    type: MutableState<BottomSheetType>,
    backgroundColor: Color,
    selectedColor: MutableState<Color>,
    bottomSheetVisibility: MutableState<Boolean>,
    bottomSheetState: ModalBottomSheetState,
    onColorChanged: (Int) -> Unit,
    content: @Composable () -> Unit
) {
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 1.dp)
                    .background(backgroundColor)
            ) {
                if (bottomSheetVisibility.value) {
                    when (type.value) {
                        BottomSheetType.MoreContent -> {
                            MoreContentBottomSheet()
                        }

                        BottomSheetType.Setting -> {
                            SettingBottomSheet(selectedColor)
                        }
                    }
                }
            }
        }, content = {
            content()
        }
    )

    LaunchedEffect(backgroundColor.value) {
        onColorChanged(ColorsUtil.todoItemColors.indexOf(backgroundColor))
    }
}

enum class BottomSheetType {
    MoreContent,
    Setting
}
