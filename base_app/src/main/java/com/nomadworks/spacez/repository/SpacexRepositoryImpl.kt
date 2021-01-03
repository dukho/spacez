package com.nomadworks.spacez.repository

import com.nomadworks.spacez.api.SpacexService
import com.nomadworks.spacez.api.model.launch.Launch
import com.nomadworks.spacez.config.dispatchers.CoroutineDispatcherProvider
import kotlinx.coroutines.withContext

class SpacexRepositoryImpl(private val spacexService: SpacexService,
                           private val dispatcherProvider: CoroutineDispatcherProvider): SpacexRepository {
    override suspend fun fetchLatestLaunch(): Launch {
        return withContext(dispatcherProvider.backgroundDispatcher){
            spacexService.getLatestLaunch()
        }
    }
}