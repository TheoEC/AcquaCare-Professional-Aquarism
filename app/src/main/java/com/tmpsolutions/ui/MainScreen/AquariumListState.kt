package com.tmpsolutions.ui.MainScreen

import com.tmpsolutions.domain.model.AquariumDomain

sealed interface AquariumListState {
    data object Loading : AquariumListState
    data object Empty : AquariumListState
    data class Error(val message: String) : AquariumListState
    data class Success(var aquariums : List<AquariumDomain>) : AquariumListState
}