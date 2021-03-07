package com.nomadworks.spacez.common.config.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    val ioDispatcher: CoroutineDispatcher
    val mainDispatcher: CoroutineDispatcher
    val defaultDispatcher: CoroutineDispatcher
}
