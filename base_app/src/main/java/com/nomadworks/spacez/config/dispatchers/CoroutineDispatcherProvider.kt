package com.nomadworks.spacez.config.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    val backgroundDispatcher: CoroutineDispatcher
}