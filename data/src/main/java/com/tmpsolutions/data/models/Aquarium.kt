package com.tmpsolutions.data.models

import java.util.Date

typealias AquariumModel = Aquarium

data class Aquarium(
    val ID: Int,

    var SaltyWater: Boolean,

    val creationData: Date,
    val lastModified: Date,

    var lstAnimals: List<Animal> = emptyList(),

    val width: Int,  //X
    val height: Int, //Y
    val length: Int, //Z

    val liters: Float,

    )

