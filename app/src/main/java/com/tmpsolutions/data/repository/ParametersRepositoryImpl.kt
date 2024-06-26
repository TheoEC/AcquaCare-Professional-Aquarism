package com.tmpsolutions.data.repository

import com.tmpsolutions.data.AquariumDao
import com.tmpsolutions.data.mapper.toDomain
import com.tmpsolutions.data.mapper.toEntity
import com.tmpsolutions.domain.model.parameters.ParameterTypeDomain
import com.tmpsolutions.domain.repository.ParametersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ParametersRepositoryImpl(
    private val dao: AquariumDao
) : ParametersRepository {
    override suspend fun getAllParameterTypes(): Flow<List<ParameterTypeDomain>> {
        return dao.getParameterTypes().map { list ->
            list.map { parameterTypeEntity ->
                parameterTypeEntity.toDomain()
            }
        }
    }

    override suspend fun insert(parameterType: ParameterTypeDomain) {
        dao.insert(parameterType.toEntity())
    }
}