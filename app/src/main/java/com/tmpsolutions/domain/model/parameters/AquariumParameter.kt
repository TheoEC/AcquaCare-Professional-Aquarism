package com.tmpsolutions.domain.model.parameters

data class AquariumParameter (
    val aquariumID : Int,
    val type : ParameterType,
    val measures : List<Measurement>
)