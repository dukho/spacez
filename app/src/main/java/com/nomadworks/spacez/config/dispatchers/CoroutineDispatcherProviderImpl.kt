package com.nomadworks.spacez.config.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CoroutineDispatcherProviderImpl() : CoroutineDispatcherProvider {
    override val backgroundDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO
}