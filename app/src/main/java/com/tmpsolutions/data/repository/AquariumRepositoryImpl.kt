package com.tmpsolutions.data.repository

import com.tmpsolutions.data.AquariumDao
import com.tmpsolutions.data.mapper.toDomain
import com.tmpsolutions.data.mapper.toEntity
import com.tmpsolutions.domain.model.AquariumDomain
import com.tmpsolutions.domain.repository.AquariumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AquariumRepositoryImpl(
    private val dao: AquariumDao
) : AquariumRepository {
    override suspend fun getAll(): Flow<List<AquariumDomain>> {
        return dao.getAll().map { list ->
            list.map { fullAquariumEntity ->
                fullAquariumEntity.toDomain()
            }
        }
    }

    override suspend fun getAquariumWithHabitants(aquariumID: Int): Flow<AquariumDomain> {
        return dao.getAquarium(aquariumID).map {  fullAquariumEntity ->
            fullAquariumEntity.toDomain()
        }
    }

    override suspend fun insertAquarium(aquarium: AquariumDomain) {
        dao.insert(aquarium.toEntity())
    }

    override suspend fun updateAquarium(aquarium: AquariumDomain) {
        dao.update(aquarium.toEntity())
    }
}