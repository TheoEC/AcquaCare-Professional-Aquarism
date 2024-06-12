package com.tmpsolutions.domain.repository

import com.tmpsolutions.domain.model.AquariumDomain
import kotlinx.coroutines.flow.Flow

interface AquariumRepository {
    suspend fun getAll() : Flow<List<AquariumDomain>>
    suspend fun insertAquarium(aquarium: AquariumDomain)
    suspend fun updateAquarium(aquarium: AquariumDomain)
}