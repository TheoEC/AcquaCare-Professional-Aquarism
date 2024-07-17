package com.tmpsolutions.domain.usecase.parameters

import com.tmpsolutions.domain.model.parameters.AquariumParameter
import com.tmpsolutions.domain.repository.ParametersRepository
import kotlinx.coroutines.flow.Flow

class GetAquariumParametersUseCase(val repository: ParametersRepository) {
    suspend operator fun invoke(aquariumId: Int) : Flow<List<AquariumParameter>> {
        return repository.getAquariumParameters(aquariumId)
    }
}