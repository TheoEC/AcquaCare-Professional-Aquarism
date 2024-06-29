package com.tmpsolutions.data.entity.paremeters

import androidx.room.Entity
import com.tmpsolutions.domain.model.parameters.Measurement
import com.tmpsolutions.domain.model.parameters.ParameterType

@Entity
data class AquariumParameter(
    val aquariumID : Int,
    val type : ParameterType,
    val measures : List<Measurement>
)
