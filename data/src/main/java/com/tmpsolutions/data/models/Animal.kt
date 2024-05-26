package com.tmpsolutions.data.models

data class Animal (
    val name: String,
    val age: Int,
    val price: Float,
    val size: Float, // Centimeters

    val minPH: Float,
    val maxPH: Float,
    val minTemp: Float,
    val maxTemp: Float,
    val saltyWater: Boolean,
)
