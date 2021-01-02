package com.nomadworks.spacez.base

import androidx.appcompat.app.AppCompatActivity
import com.nomadworks.spacez.di.BaseApplication

open class BaseActivity : AppCompatActivity() {
    protected val appComponent by lazy {
        (application as BaseApplication).getBaseAppComponent()
    }
}