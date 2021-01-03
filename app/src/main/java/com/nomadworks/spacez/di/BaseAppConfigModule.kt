package com.nomadworks.spacez.di

import com.nomadworks.spacez.config.AppConfig
import dagger.Module
import dagger.Provides

@Module
class BaseAppConfigModule(private val appConfig: AppConfig) {
    @Provides
    fun provideAppConfig(): AppConfig {
        return appConfig
    }
}