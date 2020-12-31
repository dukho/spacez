package com.nomadworks.spacez.di

import android.content.Context
import com.nomadworks.spacez.config.AppConfig
import dagger.Module
import dagger.Provides

@Module
class BaseAppConfigModule {
    @Provides
    fun provideAppConfig(context: Context): AppConfig {
        return AppConfig(configPreferences = "configs", baseUrl = "https://api.spacexdata.com/v4/")
    }
}