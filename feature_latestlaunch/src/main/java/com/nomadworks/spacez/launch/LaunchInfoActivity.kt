package com.nomadworks.spacez.launch

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.nomadworks.spacez.common.base.BaseActivity
import com.nomadworks.spacez.feature.launch.R
import com.nomadworks.spacez.feature.launch.databinding.ActivityLatestLaunchBinding
import com.nomadworks.spacez.launch.di.inject
import timber.log.Timber
import javax.inject.Inject

class LaunchInfoActivity : BaseActivity() {
    private lateinit var activityLaunchInfoBinding: ActivityLatestLaunchBinding

    private val repository by lazy {
        appComponent.getSpacexRepository()
    }

    @Inject
    lateinit var launchInfoViewModelProvider: LaunchInfoViewModelProvider

    private val viewModel by lazy {
        ViewModelProvider(this, launchInfoViewModelProvider)
            .get(LaunchInfoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        initView()

        trackScreen()
    }

    private fun initView() {
        activityLaunchInfoBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_latest_launch)
        activityLaunchInfoBinding.btnLaunchInfo.setOnClickListener {
            viewModel.requestLaunchInfo()
        }
        activityLaunchInfoBinding.launchViewModel = viewModel
        activityLaunchInfoBinding.lifecycleOwner = this
    }

    private fun trackScreen() {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            Bundle().putString("screen_name", "latest_launch")
        }
    }
}