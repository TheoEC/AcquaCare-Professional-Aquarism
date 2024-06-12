package com.tmpsolutions.domain.usecase

import com.tmpsolutions.domain.model.AquariumDomain
import com.tmpsolutions.domain.repository.AquariumRepository
import kotlinx.coroutines.flow.Flow

class GetAllAquariumsUseCase(val repository: AquariumRepository) {
    suspend operator fun invoke(): Flow<List<AquariumDomain>> {
        return repository.getAll()
    }
}