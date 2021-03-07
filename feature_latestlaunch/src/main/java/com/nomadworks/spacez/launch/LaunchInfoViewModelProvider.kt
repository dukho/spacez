package com.nomadworks.spacez.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nomadworks.spacez.common.repository.SpacexRepository
import com.nomadworks.spacez.launch.domain.GetLatestLaunchUseCase

@Suppress("UNCHECKED_CAST")
class LaunchInfoViewModelProvider(private val getLatestLaunchUseCase: GetLatestLaunchUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LaunchInfoViewModel::class.java)) {
            LaunchInfoViewModel(getLatestLaunchUseCase = getLatestLaunchUseCase) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}