package com.example.todo.presnation.todo_item.component.bottom_sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheet(
    type: MutableState<BottomSheetType>,
    backgroundColor: Color,
    selectedColor: MutableState<Color>,
    bottomSheetState: ModalBottomSheetState, content: @Composable () -> Unit
) {
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(backgroundColor)) {
                when (type.value) {
                    BottomSheetType.MoreContent -> {
                        MoreContentBottomSheet()
                    }

                    BottomSheetType.Setting -> {
                        SettingBottomSheet(selectedColor)
                    }
                }
            }
        }, content = {
            content()
        }
    )
}

enum class BottomSheetType {
    MoreContent,
    Setting
}