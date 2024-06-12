package com.tmpsolutions.data.mapper

import com.tmpsolutions.data.entity.AnimalInfoEntity
import com.tmpsolutions.data.entity.AquariumEntity
import com.tmpsolutions.data.entity.FullAquarium
import com.tmpsolutions.data.entity.HabitantEntity
import com.tmpsolutions.data.entity.HabitantWithInfo
import com.tmpsolutions.domain.model.AnimalInfoDomain
import com.tmpsolutions.domain.model.AquariumDomain
import com.tmpsolutions.domain.model.Habitant
import com.tmpsolutions.domain.model.HabitantDomain

fun AquariumDomain.toEntity() = AquariumEntity (
    id = id,
    name = name,
    saltyWater = saltyWater,
    creationData = creationData,
    lastModified = lastModified,
//    habitants = habitants,
    width = width,
    height = height,
    length = length,
    liters = liters
)

fun AquariumEntity.toDomain() = AquariumDomain (
    id = id,
    name = name,
    saltyWater = saltyWater,
    creationData = creationData,
    lastModified = lastModified,
    habitants = emptyList(),
    width = width,
    height = height,
    length = length,
    liters = liters
)

fun FullAquarium.toDomain() : AquariumDomain {
    val result = this.aquarium.toDomain()
    result.habitants = this.habitants.map {
        it.toHabitantDomain()
    }
    return result
}

fun HabitantWithInfo.toHabitantDomain() : HabitantDomain {
    var result = this.habitant.toDomain()
    result.taxonomy = animalInfo?.toDomain()
    return result
}

fun HabitantEntity.toDomain() = HabitantDomain(
    id = id,
    aquariumId = aquariumId,
    name = name,
    qtd = qtd,
    gender = gender
)

fun AnimalInfoEntity.toDomain() = AnimalInfoDomain(
    id = id,
    scientificName = scientificName,
    commonName = commonName,
    custom = custom,
    size = size,
    minPH = minPH,
    maxPH = maxPH,
    minTemp = minTemp,
    maxTemp = maxTemp,
    saltyWater = saltyWater
)