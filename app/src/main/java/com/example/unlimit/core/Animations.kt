package com.example.unlimit.core

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun AnimateSlideHorizontally(
    delayInMillis: Long,
    durationInMillis: Long,
    content: @Composable () -> Unit
) {
    val state = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    AnimatedVisibility(
        visibleState = state,
        enter = slideInHorizontally(
            animationSpec = tween(500, delayMillis = 100),
            initialOffsetX = { -it }
        )) {
        content.invoke()
    }
}