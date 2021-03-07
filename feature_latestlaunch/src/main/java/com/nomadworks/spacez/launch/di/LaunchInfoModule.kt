package com.nomadworks.spacez.launch.di

import com.nomadworks.spacez.launch.LaunchInfoViewModelProvider
import com.nomadworks.spacez.common.repository.SpacexRepository
import com.nomadworks.spacez.launch.domain.GetLatestLaunchUseCase
import dagger.Module
import dagger.Provides

@Module
class LaunchInfoModule {
    @Provides
    fun provideLaunchInfoViewModelProvider(getLatestLaunchUseCase: GetLatestLaunchUseCase) : LaunchInfoViewModelProvider {
        return LaunchInfoViewModelProvider(getLatestLaunchUseCase = getLatestLaunchUseCase)
    }

    @Provides
    fun provideGetLatestLaunchUseCase(repository: SpacexRepository): GetLatestLaunchUseCase {
        return GetLatestLaunchUseCase(repository)
    }
}
