package com.tmpsolutions.domain.usecase.parameters

import com.tmpsolutions.domain.repository.ParametersRepository

class AddAquariumParameterUseCase(val repository: ParametersRepository) {
    suspend operator fun invoke(aquariumID: Int, parametertypeID: Int) {
        repository.insertAquariumParameter(aquariumID, parametertypeID)
    }
}