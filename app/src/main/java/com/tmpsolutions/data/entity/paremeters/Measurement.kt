package com.tmpsolutions.data.entity.paremeters

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

typealias MeasurementEntity = Measurement

@Entity(
    foreignKeys = [
        ForeignKey(entity = AquariumParameter::class, parentColumns = ["id"], childColumns = ["parameter_id"], onDelete = ForeignKey.CASCADE)
    ]
)
data class Measurement(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "parameter_id") val ParameterID : Int,
    val date: Date,
    val value: Float,
    val value2: Float? = null
)
