package com.nomadworks.spacez.launch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.nomadworks.spacez.R
import com.nomadworks.spacez.databinding.ActivityLaunchInfoBinding
import com.nomadworks.spacez.di.BaseApplication
import kotlinx.coroutines.launch
import timber.log.Timber

class LaunchInfoActivity : AppCompatActivity() {
    private lateinit var activityLaunchInfoBinding: ActivityLaunchInfoBinding
    private val appComponent by lazy {
        (application as BaseApplication).getBaseAppComponent()
    }
    private val repository by lazy {
        appComponent.getSpacexRepository()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLaunchInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_launch_info)
        activityLaunchInfoBinding.btnLaunchInfo.setOnClickListener {
            Timber.d("[space] repository: $repository")
            lifecycleScope.launch {
                val launch = repository.fetchLatestLaunch()
                Timber.d("[space] launch result: $launch")
            }
        }
    }
}