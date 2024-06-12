package com.tmpsolutions.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class FullAquarium (
    @Embedded val aquarium : AquariumEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "aquarium_id",
        entity = HabitantEntity::class
    )
    val habitants : List<HabitantWithInfo>
)