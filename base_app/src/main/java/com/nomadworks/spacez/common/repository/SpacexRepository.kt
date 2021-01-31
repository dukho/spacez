package com.nomadworks.spacez.common.repository

import com.nomadworks.spacez.common.api.model.launch.Launch

interface SpacexRepository {
    suspend fun fetchLatestLaunch(): Launch
}