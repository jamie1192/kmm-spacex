package com.jastley.innovationday.android

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.savedstate.SavedStateRegistryOwner
import com.jastley.innovationday.shared.SpaceXSDK
import com.jastley.innovationday.shared.entity.RocketLaunch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LaunchViewModel(private val state: SavedStateHandle, sdk: SpaceXSDK): ViewModel() {
    val launchList = MutableStateFlow<List<RocketLaunch>>(listOf())

    init {
        viewModelScope.launch {
            kotlin.runCatching {
                sdk.getLaunches(false)
            }.onSuccess {
                launchList.emit(it)
            }.onFailure {
                // TODO: handle error
            }
        }
    }
}

// https://stackoverflow.com/a/60130631/6716211
class LaunchViewModelFactory(
    private val owner: SavedStateRegistryOwner,
    private val sdk: SpaceXSDK) : AbstractSavedStateViewModelFactory(owner, null) {
    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, state: SavedStateHandle) =
        LaunchViewModel(state, sdk) as T
}
