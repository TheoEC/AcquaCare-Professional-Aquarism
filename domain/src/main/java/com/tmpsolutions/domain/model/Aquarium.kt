package com.tmpsolutions.domain.model

import java.util.Date

typealias AquariumDomain = Aquarium

data class Aquarium (
    val id: Int,
    val name: String = "",

    var saltyWater: Boolean,

    val creationData: Date,
    val lastModified: Date,

    var Animals: List<Animal> = emptyList(),

    val width: Int,  //X
    val height: Int, //Y
    val length: Int, //Z

    val liters: Float,
)