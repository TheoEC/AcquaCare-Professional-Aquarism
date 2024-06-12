package com.tmpsolutions.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

typealias AquariumEntity = Aquarium

@Entity
data class Aquarium(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String = "",

    var saltyWater: Boolean,

    val creationData: Date,
    val lastModified: Date,

    val width: Int,  //X
    val height: Int, //Y
    val length: Int, //Z

    val liters: Float,
)

