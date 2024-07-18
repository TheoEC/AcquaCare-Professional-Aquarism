package com.tmpsolutions.data.repository

import com.tmpsolutions.data.AquariumDao
import com.tmpsolutions.data.entity.paremeters.AquariumParameter
import com.tmpsolutions.data.mapper.toDomain
import com.tmpsolutions.data.mapper.toEntity
import com.tmpsolutions.domain.model.parameters.AquariumParameterDomain
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

    override suspend fun getAquariumParameters(aquariumID: Int): Flow<List<AquariumParameterDomain>> {
        val result = dao.getAllAquariumParameters(aquariumID)
        return result.map { list ->
            list.map { parameterEntity ->
                val lastMeasurement = dao.getLastMeasurement(parameterEntity.aquariumParameter.id)

                AquariumParameterDomain(
                    aquariumID = parameterEntity.aquariumParameter.id,
                    type = parameterEntity.type?.toDomain(),
                    lastMeasurement = lastMeasurement?.toDomain()
                )
            }
        }
    }

    override suspend fun insertAquariumParameter(aquariumID: Int, parametertypeID: Int) {
        dao.insert(
            AquariumParameter(
                aquariumID = aquariumID,
                typeID = parametertypeID
            )
        )
    }

    override suspend fun insert(parameterType: ParameterTypeDomain) {
        dao.insert(parameterType.toEntity())
    }
}