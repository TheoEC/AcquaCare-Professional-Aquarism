package com.tmpsolutions.data.entity.paremeters

import androidx.room.Embedded
import androidx.room.Relation

data class AquariumParameterWithType (
    @Embedded val aquariumParameter: AquariumParameter,
    @Relation(
        parentColumn = "type_id",
        entityColumn = "id",
        entity = ParameterType::class
    )
    val type: ParameterType?
)