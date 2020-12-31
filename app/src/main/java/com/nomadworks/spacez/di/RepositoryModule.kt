package com.nomadworks.spacez.di

import com.nomadworks.spacez.api.SpacexService
import com.nomadworks.spacez.config.dispatchers.CoroutineDispatcherProvider
import com.nomadworks.spacez.repository.SpacexRepository
import com.nomadworks.spacez.repository.SpacexRepositoryImpl
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