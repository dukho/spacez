package com.nomadworks.spacez.common.repository

import com.nomadworks.spacez.common.api.SpacexService
import com.nomadworks.spacez.common.api.model.launch.Launch
import com.nomadworks.spacez.common.config.dispatchers.CoroutineDispatcherProvider
import kotlinx.coroutines.withContext

class SpacexRepositoryImpl(private val spacexService: SpacexService,
                           private val dispatcherProvider: CoroutineDispatcherProvider): SpacexRepository {
    override suspend fun fetchLatestLaunch(): Launch {
        return withContext(dispatcherProvider.ioDispatcher){
            spacexService.getLatestLaunch()
        }
    }
}
