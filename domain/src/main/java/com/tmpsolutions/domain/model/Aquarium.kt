package com.tmpsolutions.domain.model

typealias AquariumDomain = Aquarium
data class Aquarium (
    var id: Int = 0,
    var name: String = "",
    var liters: Float,
    var length: Float,
    var width: Float,
    var height: Float

)