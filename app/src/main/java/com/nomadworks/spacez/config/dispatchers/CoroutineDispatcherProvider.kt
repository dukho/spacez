package com.nomadworks.spacez.config.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    open val backgroundDispatcher: CoroutineDispatcher
}