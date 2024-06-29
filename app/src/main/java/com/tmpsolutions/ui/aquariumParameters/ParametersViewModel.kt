package com.tmpsolutions.ui.aquariumParameters

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class ParametersViewModel(
    id: Int,

) : ViewModel() {
    private val _state = MutableSharedFlow<ParameterState>(replay = 1)
    val state : SharedFlow<ParameterState> = _state

    init {

    }

    fun getParameters(id: Int) {

    }
}