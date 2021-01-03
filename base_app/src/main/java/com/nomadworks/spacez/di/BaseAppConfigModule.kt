package com.nomadworks.spacez.di

import com.nomadworks.spacez.config.AppConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class BaseAppConfigModule(
    private val appConfig: AppConfig,
    private val versionName: String,
    private val versionCode: String
) {
    @Provides
    fun provideAppConfig(): AppConfig {
        return appConfig
    }

    @Named("VERSION_CODE")
    @Provides
    fun provideVersionCode(): String {
        return versionCode
    }

    @Named("VERSION_NAME")
    @Provides
    fun provideVersionName(): String {
        return versionName
    }
}