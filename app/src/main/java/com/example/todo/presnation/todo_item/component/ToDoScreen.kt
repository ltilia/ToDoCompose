package com.example.todo.presnation.todo_item.component

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.todo.presnation.todo_item.TodoItemViewModel
import com.example.todo.presnation.todo_item.component.bottom_sheet.BottomSheetType
import com.example.todo.presnation.todo_item.component.bottom_sheet.ModalBottomSheet
import com.example.todo.presnation.ui.theme.DARK_GREEN
import kotlinx.coroutines.launch
import com.example.todo.presnation.todo_item.TodoItemViewModel.TodoScreenEvent.*

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun TodoScreen(
    navHostController: NavHostController,
    viewModel: TodoItemViewModel = hiltViewModel()
) {
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
        mutableStateOf(DARK_GREEN)
    }
    val animatedColor = animateColorAsState(
        targetValue = backgroundColor.value,
        animationSpec = TweenSpec<Color>(
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
                bottomSheetVisibility = bottomSheetVisibility

            ) {
                Column {
                    Header(onBackButtonPressed = {
                        viewModel.onEvent(OnBackButtonPressed)
                        navHostController.popBackStack()
                    })
                    ToDoContent(Modifier.weight(1f), state, onTitleChanged = { title ->
                        viewModel.onEvent(OnTitleChange(title))
                    }, onContentChanged = { content ->
                        viewModel.onEvent(OnContentChange(content))
                    }
                    )
                }
            }
        }

        Footer(color = animatedColor.value, showBottomSheet = { type ->
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