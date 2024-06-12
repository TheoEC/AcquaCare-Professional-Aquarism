package com.tmpsolutions.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class HabitantWithInfo(
    @Embedded val habitant: HabitantEntity,
    @Relation(
        parentColumn = "animal_info_id",
        entityColumn = "id"
    )
    val animalInfo: AnimalInfoEntity?
)
