package com.example.todo.presnation.todo_item.component.bottom_sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheet(
    type: MutableState<BottomSheetType>,
    backgroundColor: Color,
    selectedColor: MutableState<Color>,
    bottomSheetVisibility: MutableState<Boolean>,
    bottomSheetState: ModalBottomSheetState, content: @Composable () -> Unit
) {
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 1.dp)
                    .background(backgroundColor)) {
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
}

enum class BottomSheetType {
    MoreContent,
    Setting
}