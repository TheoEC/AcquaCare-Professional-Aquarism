package com.tmpsolutions.ui.AquariumDetails

import com.tmpsolutions.domain.model.AquariumDomain

sealed interface AquariumDetailState {
    data object Loading : AquariumDetailState
    data class Error(val message : String) : AquariumDetailState
    data class Success(val aquarium: AquariumDomain) : AquariumDetailState
}
