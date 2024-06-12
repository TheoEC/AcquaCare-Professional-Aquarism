package com.tmpsolutions.domain.model

import java.util.Date

typealias AquariumDomain = Aquarium

data class Aquarium (
    val id: Int = 0,
    val name: String = "",

    var saltyWater: Boolean,

    val creationData: Date,
    val lastModified: Date,

    var habitants: List<Habitant>,

    val width: Int = 0,  //X
    val height: Int = 0, //Y
    val length: Int = 0, //Z

    val liters: Float = 0f,
)