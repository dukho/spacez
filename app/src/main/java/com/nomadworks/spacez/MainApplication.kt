package com.nomadworks.spacez

import android.app.Application
import com.nomadworks.spacez.di.BaseAppComponent
import com.nomadworks.spacez.di.BaseAppModule
import com.nomadworks.spacez.di.BaseApplication
import com.nomadworks.spacez.di.DaggerBaseAppComponent
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
            .build()
    }

    override fun getBaseAppComponent(): BaseAppComponent {
        return baseAppComponent
    }
}