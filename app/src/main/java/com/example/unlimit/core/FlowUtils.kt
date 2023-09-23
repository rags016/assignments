package com.example.unlimit.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

fun <T> Flow<T>.onceIn(scope: CoroutineScope){
    val flow = this
    scope.launch {
        kotlin.runCatching {
            flow.firstOrNull()
        }.getOrNull()
    }
}