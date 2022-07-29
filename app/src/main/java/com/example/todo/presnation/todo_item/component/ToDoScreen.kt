package com.example.todo.presnation.todo_item.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.presnation.todo_item.TodoItemViewModel
import com.example.todo.presnation.todo_item.TodoItemViewModel.TodoScreenEvent.OnBackButtonPressed
import com.example.todo.presnation.todo_item.TodoItemViewModel.TodoScreenEvent.OnContentChange
import com.example.todo.presnation.todo_item.TodoItemViewModel.TodoScreenEvent.OnTitleChange
import com.example.todo.presnation.todo_item.component.bottom_sheet.BottomSheetType
import com.example.todo.presnation.todo_item.component.bottom_sheet.ModalBottomSheet
import com.example.todo.presnation.todo_item.util.ColorsUtil
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TodoScreen(viewModel: TodoItemViewModel = hiltViewModel()) {
    val state = viewModel.state
    val coroutineScope = rememberCoroutineScope()

    val bottomSheetVisibility = remember {
        mutableStateOf(false)
    }
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden, confirmStateChange = { value ->
            when (value) {
                ModalBottomSheetValue.Hidden -> {
                    bottomSheetVisibility.value = false
                }

                else -> {
                    bottomSheetVisibility.value = true
                }
            }

            true
        }
    )
    val bottomSheetType = remember {
        mutableStateOf(BottomSheetType.MoreContent)
    }
    val backgroundColor = remember {
        mutableStateOf(ColorsUtil.getColor(state.value.color))
    }

    val animatedColor = animateColorAsState(
        targetValue = backgroundColor.value,
        animationSpec = TweenSpec(
            2500, 300, LinearOutSlowInEasing
        )
    )

    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(animatedColor.value)
            .imePadding()
    ) {
        Box(
            Modifier
                .weight(1f)
        ) {
            ModalBottomSheet(
                type = bottomSheetType,
                backgroundColor = animatedColor.value,
                bottomSheetState = bottomSheetState,
                selectedColor = backgroundColor,
                bottomSheetVisibility = bottomSheetVisibility,
                onColorChanged = { colorIndex ->
                    viewModel.onEvent(TodoItemViewModel.TodoScreenEvent.OnColorChange(colorIndex))
                }
            ) {
                Column {
                    TopAppBar(onBackButtonPressed = {
                        viewModel.onEvent(OnBackButtonPressed)
                    })
                    ToDoContent(
                        Modifier.weight(1f), state, onTitleChanged = { title ->
                            viewModel.onEvent(OnTitleChange(title))
                        }, onContentChanged = { content ->
                            viewModel.onEvent(OnContentChange(content))
                        }
                    )
                }
            }
        }

        SettingsBar(color = animatedColor.value, showBottomSheet = { type ->
            focusManager.clearFocus(true)
            bottomSheetType.value = type
            coroutineScope.launch {
                bottomSheetVisibility.value = true
                bottomSheetState.animateTo(
                    targetValue = ModalBottomSheetValue.Expanded,
                    anim = tween(
                        delayMillis = 300,
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                )
            }
        })
    }
}
