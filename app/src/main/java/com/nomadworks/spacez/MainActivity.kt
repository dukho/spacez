package com.nomadworks.spacez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.nomadworks.spacez.databinding.ActivityMainBinding
import com.nomadworks.spacez.launch.LaunchInfoActivity

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtain the FirebaseAnalytics instance.
        firebaseAnalytics = Firebase.analytics

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.btnLaunch.setOnClickListener {
            startActivity(
                Intent(this, LaunchInfoActivity::class.java)
            )
        }

        trackAppLaunch()
    }

    private fun trackAppLaunch() {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN) {
            Bundle().putString("start_argument", "launching")
        }
    }
}
