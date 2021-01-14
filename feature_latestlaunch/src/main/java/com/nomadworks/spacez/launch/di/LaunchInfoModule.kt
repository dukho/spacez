package com.nomadworks.spacez.launch.di

import com.nomadworks.spacez.launch.LaunchInfoViewModelProvider
import com.nomadworks.spacez.common.repository.SpacexRepository
import dagger.Module
import dagger.Provides

@Module
class LaunchInfoModule {
    @Provides
    fun provideLaunchInfoViewModelProvider(repository: SpacexRepository) : LaunchInfoViewModelProvider {
        return LaunchInfoViewModelProvider(repository = repository)
    }
}