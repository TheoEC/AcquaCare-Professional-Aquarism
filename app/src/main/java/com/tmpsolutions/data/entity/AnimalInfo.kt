package com.tmpsolutions.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

typealias AnimalInfoEntity = AnimalInfo

@Entity
data class AnimalInfo (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "scientific_name") val scientificName: String,
    @ColumnInfo(name = "common_name") val commonName: String,
    val custom: Boolean,
    val size: Float, // Centimeters

    val minPH: Float,
    val maxPH: Float,
    val minTemp: Float,
    val maxTemp: Float,
    val saltyWater: Boolean,
)