package com.nomadworks.spacez

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.nomadworks.spacez.common.base.BaseActivity
import com.nomadworks.spacez.databinding.ActivityMainBinding
import com.nomadworks.spacez.launch.LaunchInfoActivity

class MainActivity : BaseActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.btnLaunch.setOnClickListener {
            startActivity(
                Intent(this, LaunchInfoActivity::class.java)
            )
        }

        trackAppLaunch()
    }

    private fun trackAppLaunch() {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            Bundle().putString("screen_name", "main")
        }
    }
}
