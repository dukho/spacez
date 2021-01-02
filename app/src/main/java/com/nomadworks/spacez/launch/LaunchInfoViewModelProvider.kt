package com.nomadworks.spacez.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nomadworks.spacez.repository.SpacexRepository

@Suppress("UNCHECKED_CAST")
class LaunchInfoViewModelProvider(private val repository: SpacexRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LaunchInfoViewModel::class.java)) {
            LaunchInfoViewModel(repository = repository) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}