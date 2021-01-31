package com.nomadworks.spacez.common.di

import com.nomadworks.spacez.common.config.dispatchers.CoroutineDispatcherProvider
import com.nomadworks.spacez.common.config.dispatchers.CoroutineDispatcherProviderImpl
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