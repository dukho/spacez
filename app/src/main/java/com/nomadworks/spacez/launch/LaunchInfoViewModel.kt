package com.nomadworks.spacez.launch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nomadworks.spacez.api.model.launch.Launch
import com.nomadworks.spacez.repository.SpacexRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class LaunchInfoViewModel(private val repository: SpacexRepository) : ViewModel(),
    LaunchInfoContract.ViewModel {
    data class ViewState(
        val launchInfo: String,
        val launchName: String,
        val patchImageLink: String?,
        val launchImageLink: String?,
        val showWait: Boolean
    )

    private var viewStateSnapshot = ViewState(
        showWait = false,
        launchInfo = "",
        launchName = "",
        patchImageLink = null,
        launchImageLink = null
    )
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
            updateViewState(
                viewStateSnapshot.copy(
                    launchInfo = "Fetching...",
                    launchName = "",
                    launchImageLink = null,
                    patchImageLink = null,
                    showWait = true
                )
            )
            val launch = repository.fetchLatestLaunch()
            Timber.d("[space] launch result from viewmodel: $launch")
            updateLaunchInfo(launch)
        }
    }

    private fun updateLaunchInfo(launch: Launch) {
        updateViewState(viewStateSnapshot.copy(
            launchInfo = "${launch.details}",
            launchName = "${launch.name}",
            launchImageLink = launch.links?.let {
                if (it.flickr?.original?.isNotEmpty() == true) {
                    it.flickr?.original?.get(0)
                } else {
                    null
                }
            },
            patchImageLink = launch.links?.let {
                if (it.patch?.small?.isNotBlank() == true) {
                    it.patch?.small
                } else {
                    null
                }
            },
            showWait = false))
    }
}