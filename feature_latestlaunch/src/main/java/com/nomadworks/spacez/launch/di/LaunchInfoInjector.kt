package com.nomadworks.spacez.launch.di

import com.nomadworks.spacez.common.di.BaseAppComponent
import com.nomadworks.spacez.common.di.BaseApplication
import com.nomadworks.spacez.launch.LaunchInfoActivity

fun LaunchInfoActivity.inject() {
    buildLaunchInfoComponent((application as BaseApplication).getBaseAppComponent()).inject(this)
}

private fun buildLaunchInfoComponent(baseAppComponent: BaseAppComponent): LaunchInfoComponent {
    return DaggerLaunchInfoComponent.builder()
        .baseAppComponent(baseAppComponent)
        .build()
}