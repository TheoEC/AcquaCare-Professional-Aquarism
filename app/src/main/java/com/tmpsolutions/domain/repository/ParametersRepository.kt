package com.tmpsolutions.domain.repository

import com.tmpsolutions.domain.model.parameters.AquariumParameter
import com.tmpsolutions.domain.model.parameters.ParameterTypeDomain
import kotlinx.coroutines.flow.Flow

interface ParametersRepository {
    suspend fun getAllParameterTypes() : Flow<List<ParameterTypeDomain>>
    suspend fun getAquariumParameters(aquariumID: Int) : Flow<List<AquariumParameter>>
    suspend fun insert(parameterType: ParameterTypeDomain)
}