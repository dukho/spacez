package com.nomadworks.spacez

import android.app.Application
import com.nomadworks.spacez.common.config.AppConfig
import com.nomadworks.spacez.common.di.*
import timber.log.Timber

class MainApplication : Application(), BaseApplication {
    private lateinit var baseAppComponent: BaseAppComponent

    override fun onCreate() {
        super.onCreate()

        initLogging()
        initDI()
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDI() {
        baseAppComponent = DaggerBaseAppComponent.builder()
            .baseAppModule(BaseAppModule(applicationContext))
            .baseAppConfigModule(
                BaseAppConfigModule(
                    createAppConfig(),
                    BuildConfig.VERSION_NAME,
                    BuildConfig.VERSION_CODE.toString()
                )
            )
            .build()
    }

    override fun getBaseAppComponent(): BaseAppComponent {
        return baseAppComponent
    }

    private fun createAppConfig(): AppConfig {
        return AppConfig(configPreferences = "configs", baseUrl = "https://api.spacexdata.com/v4/")
    }
}