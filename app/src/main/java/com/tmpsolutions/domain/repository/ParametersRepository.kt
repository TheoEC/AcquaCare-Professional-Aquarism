package com.tmpsolutions.domain.repository

import com.tmpsolutions.domain.model.parameters.ParameterTypeDomain
import kotlinx.coroutines.flow.Flow

interface ParametersRepository {
    suspend fun getAllParameterTypes() : Flow<List<ParameterTypeDomain>>
    suspend fun insert(parameterType: ParameterTypeDomain)
}