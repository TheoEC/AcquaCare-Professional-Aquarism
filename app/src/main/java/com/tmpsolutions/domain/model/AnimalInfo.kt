package com.tmpsolutions.domain.model

typealias AnimalInfoDomain = AnimalInfo

data class AnimalInfo (
    val id: Int = 0,
    val scientificName: String,
    val commonName: String,
    val custom: Boolean = false,
    val size: Float, // Centimeters

    val minPH: Float,
    val maxPH: Float,
    val minTemp: Float,
    val maxTemp: Float,
    val saltyWater: Boolean,
)