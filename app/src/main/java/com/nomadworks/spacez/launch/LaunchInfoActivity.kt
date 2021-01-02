package com.nomadworks.spacez.launch

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nomadworks.spacez.R
import com.nomadworks.spacez.base.BaseActivity
import com.nomadworks.spacez.databinding.ActivityLaunchInfoBinding
import com.nomadworks.spacez.launch.di.inject
import timber.log.Timber
import javax.inject.Inject

class LaunchInfoActivity : BaseActivity() {
    private lateinit var activityLaunchInfoBinding: ActivityLaunchInfoBinding

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
    }

    private fun initView() {
        activityLaunchInfoBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_launch_info)
        activityLaunchInfoBinding.btnLaunchInfo.setOnClickListener {
            viewModel.requestLaunchInfo()
        }
        activityLaunchInfoBinding.viewModel = viewModel
        activityLaunchInfoBinding.lifecycleOwner = this
    }
}