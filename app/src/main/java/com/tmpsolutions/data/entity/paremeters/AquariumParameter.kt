package com.tmpsolutions.data.entity.paremeters

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.tmpsolutions.data.entity.AquariumEntity

@Entity(
    tableName = "aquarium_parameter",
    foreignKeys = [
        ForeignKey(entity = AquariumEntity::class, parentColumns = ["id"], childColumns = ["aquarium_id"], onDelete = ForeignKey.CASCADE)
    ]
)
data class AquariumParameter(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "aquarium_id") val aquariumID : Int,
    @ColumnInfo(name = "type_id") val typeID : Int,
)
