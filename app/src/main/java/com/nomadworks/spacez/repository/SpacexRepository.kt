package com.nomadworks.spacez.repository

import com.nomadworks.spacez.api.model.launch.Launch

interface SpacexRepository {
    suspend fun fetchLatestLaunch(): Launch
}