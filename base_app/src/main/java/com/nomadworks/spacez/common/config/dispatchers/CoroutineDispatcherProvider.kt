package com.nomadworks.spacez.common.config.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    val backgroundDispatcher: CoroutineDispatcher
}