package com.nomadworks.spacez.launch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nomadworks.spacez.repository.SpacexRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class LaunchInfoViewModel(private val repository: SpacexRepository) : ViewModel(), LaunchInfoContract.ViewModel {
    data class ViewState(
        val launchInfo: String,
        val showWait: Boolean
    )

    private var viewStateSnapshot = ViewState(launchInfo = "", showWait = false)
    private val mutableViewState = MutableLiveData<ViewState>(
        viewStateSnapshot
    )
    val viewState: LiveData<ViewState> = mutableViewState
    private fun updateViewState(viewState: ViewState) {
        viewStateSnapshot = viewState
        mutableViewState.postValue(viewStateSnapshot)
    }


    override fun requestLaunchInfo() {
        viewModelScope.launch {
            updateViewState(viewStateSnapshot.copy(launchInfo = "Fetching...", showWait = true))
            val launch = repository.fetchLatestLaunch()
            Timber.d("[space] launch result from viewmodel: $launch")
            updateViewState(viewStateSnapshot.copy(launchInfo = "$launch", showWait = false))
        }
    }
}