package com.nomadworks.spacez.di

import com.nomadworks.spacez.config.dispatchers.CoroutineDispatcherProvider
import com.nomadworks.spacez.config.dispatchers.CoroutineDispatcherProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseDispatcherModule {
    @Singleton
    @Provides
    fun provideDispatcherProvider(): CoroutineDispatcherProvider {
        return CoroutineDispatcherProviderImpl()
    }
}