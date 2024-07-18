package com.tmpsolutions.domain.model.parameters

typealias AquariumParameterDomain = AquariumParameter

data class AquariumParameter (
    val aquariumID : Int,
    val type : ParameterType?,
    val lastMeasurement: Measurement?
)