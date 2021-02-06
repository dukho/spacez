package com.nomadworks.spacez.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.nomadworks.spacez.common.di.BaseApplication

open class BaseActivity : AppCompatActivity() {
    protected val appComponent by lazy {
        (application as BaseApplication).getBaseAppComponent()
    }

    protected lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Obtain the FirebaseAnalytics instance.
        firebaseAnalytics = Firebase.analytics
    }
}