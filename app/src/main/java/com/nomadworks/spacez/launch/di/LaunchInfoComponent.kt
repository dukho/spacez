package com.nomadworks.spacez.launch.di

import com.nomadworks.spacez.di.BaseAppComponent
import com.nomadworks.spacez.di.scope.ActivityScope
import com.nomadworks.spacez.launch.LaunchInfoActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [BaseAppComponent::class], modules = [LaunchInfoModule::class])
interface LaunchInfoComponent {
    fun inject(activity: LaunchInfoActivity)
}