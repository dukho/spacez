package com.nomadworks.spacez.common.config.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CoroutineDispatcherProviderImpl() : CoroutineDispatcherProvider {
    override val ioDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO

    override val mainDispatcher: CoroutineDispatcher
        get() = Dispatchers.Main

    override val defaultDispatcher: CoroutineDispatcher
        get() = Dispatchers.Default
}
