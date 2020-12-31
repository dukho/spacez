package com.nomadworks.spacez.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.nomadworks.spacez.config.AppConfig
import com.nomadworks.spacez.resource.ResourceQuery
import com.nomadworks.spacez.resource.ResourceQueryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseAppModule(
        private val context: Context
) {
    @Provides
    fun provideContext(): Context = context

    @Singleton
    @Provides
    fun provideSharedPreference(context: Context, appConfig: AppConfig): SharedPreferences {
        return context.getSharedPreferences(appConfig.configPreferences, MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun providesResourceQuery(context: Context): ResourceQuery {
        return ResourceQueryImpl(context)
    }
}