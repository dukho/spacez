package com.nomadworks.spacez.common.di

import com.nomadworks.spacez.common.api.SpacexService
import com.nomadworks.spacez.common.config.dispatchers.CoroutineDispatcherProvider
import com.nomadworks.spacez.common.repository.SpacexRepository
import com.nomadworks.spacez.common.repository.SpacexRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideSpacexRepository(spacexService: SpacexService, dispatcherProvider: CoroutineDispatcherProvider): SpacexRepository {
        return SpacexRepositoryImpl(spacexService, dispatcherProvider)
    }
}