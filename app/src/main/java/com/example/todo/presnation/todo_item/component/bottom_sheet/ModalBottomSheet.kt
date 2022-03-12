package com.example.todo.presnation.todo_item.component.bottom_sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.example.todo.R
import com.example.todo.presnation.todo_item.component.BottomSheenItem
import com.example.todo.presnation.ui.theme.DARK_GREEN

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheet(
    type: MutableState<BottomSheetType>,
    bottomSheetState: ModalBottomSheetState, content: @Composable () -> Unit ) {
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(DARK_GREEN)) {
                when (type.value) {
                    BottomSheetType.MoreContent -> {
                        MoreContentBottomSheet()
                    }

                    BottomSheetType.Setting -> {
                        SettingBottomSheet()
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