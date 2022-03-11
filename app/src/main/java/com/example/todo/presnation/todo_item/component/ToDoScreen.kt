package com.example.todo.presnation.todo_item.component

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun TodoScreen() {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    Column(modifier = Modifier.fillMaxSize()) {
        MoreBottomSheet(bottomSheetState = bottomSheetState) {
            Column(Modifier.weight(1f)) {
                Header()
                ToDoContent(Modifier.weight(1f))
                Footer(showMoreContent = {
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
    }
}