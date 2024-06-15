package com.tmpsolutions.domain.usecase

import com.tmpsolutions.data.entity.FullAquarium
import com.tmpsolutions.domain.model.AquariumDomain
import com.tmpsolutions.domain.repository.AquariumRepository
import kotlinx.coroutines.flow.Flow

class GetAquariumUseCase(
    private val repository: AquariumRepository
) {
    suspend operator fun invoke(aquariumId : Int): Flow<AquariumDomain> {
        return repository.getAquariumWithHabitants(aquariumId)
    }
}