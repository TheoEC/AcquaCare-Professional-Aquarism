package com.tmpsolutions.ui.aquariumParameters

import com.tmpsolutions.domain.model.parameters.AquariumParameter

sealed class ParameterState {
    data object Loading : ParameterState()
    data class Error(val message : String) : ParameterState()
    data class Success(val parameters : List<AquariumParameter>) : ParameterState()
}