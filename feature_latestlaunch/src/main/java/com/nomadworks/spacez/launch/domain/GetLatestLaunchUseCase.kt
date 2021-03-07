package com.nomadworks.spacez.launch.domain

import com.nomadworks.spacez.common.api.model.launch.Launch
import com.nomadworks.spacez.common.repository.SpacexRepository

class GetLatestLaunchUseCase(private val repository: SpacexRepository) {
    suspend fun fetchLatestLaunch(): Launch {
        return repository.fetchLatestLaunch()
    }
}