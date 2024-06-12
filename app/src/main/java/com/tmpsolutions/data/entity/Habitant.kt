package com.tmpsolutions.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tmpsolutions.domain.model.GenderType

typealias HabitantEntity = Habitant

@Entity
data class Habitant(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "aquarium_id") val aquariumId: Int,
    @ColumnInfo(name = "animal_info_id") val animalInfoId: Int? = null,
    val name: String,
    val qtd: Int,
    val gender: GenderType? = null,
)
