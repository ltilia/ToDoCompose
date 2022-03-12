package com.example.todo.presnation.todo_item.component

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.presnation.todo_item.component.bottom_sheet.BottomSheetType
import com.example.todo.presnation.todo_item.component.bottom_sheet.ModalBottomSheet
import com.example.todo.presnation.ui.theme.DARK_GREEN
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun TodoScreen() {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val bottomSheetType  = remember {
        mutableStateOf(BottomSheetType.MoreContent)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            Modifier
                .weight(1f)
                .background(DARK_GREEN)) {
            ModalBottomSheet(type = bottomSheetType,  bottomSheetState = bottomSheetState) {
                Column {
                    Header()
                    ToDoContent()
                }
            }
        }

        Footer(showMoreContent = { type ->
            bottomSheetType.value = type
            coroutineScope.launch {
                bottomSheetState.animateTo(
                    targetValue = ModalBottomSheetValue.Expanded,
                    anim = tween(
                        delayMillis = 300,
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
            }
        })
    }
}