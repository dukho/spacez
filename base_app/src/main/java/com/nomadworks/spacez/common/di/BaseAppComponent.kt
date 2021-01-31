package com.nomadworks.spacez.common.di

import android.content.Context
import android.content.SharedPreferences
import com.nomadworks.spacez.common.config.AppConfig
import com.nomadworks.spacez.common.repository.SpacexRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    BaseAppConfigModule::class,
    BaseAppModule::class,
    BaseDispatcherModule::class,
    BaseNetworkModule::class,
    RepositoryModule::class
])
interface BaseAppComponent {
    fun getSpacexRepository(): SpacexRepository
    fun getAppConfig(): AppConfig
    fun getPreference(): SharedPreferences
    fun getContext(): Context
}