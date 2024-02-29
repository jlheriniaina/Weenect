package com.weenect.testweenect.helpers

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

@Composable
inline fun LazyListState.scrollEndCallback(crossinline callback: () -> Unit) {
    LaunchedEffect(key1 = this) {
        snapshotFlow { layoutInfo }
            .filter { it.totalItemsCount > 0 }
            .map { it.totalItemsCount == (it.visibleItemsInfo.lastOrNull()?.index ?: -1).inc() }
            .distinctUntilChanged()
            .filter { it }
            .onEach { callback() }
            .collect()
    }
}