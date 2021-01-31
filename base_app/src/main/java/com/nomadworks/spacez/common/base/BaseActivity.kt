package com.nomadworks.spacez.common.base

import androidx.appcompat.app.AppCompatActivity
import com.nomadworks.spacez.common.di.BaseApplication

open class BaseActivity : AppCompatActivity() {
    protected val appComponent by lazy {
        (application as BaseApplication).getBaseAppComponent()
    }
}