package com.tmpsolutions.data.entity.paremeters

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Measurement(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "parameter_type_id") val parameterTypeID : Int,
    @ColumnInfo(name = "aquarium_id") val aquariumId : Int,
    val date: Date,
    val value: Float,
    val value2: Float? = null
)
