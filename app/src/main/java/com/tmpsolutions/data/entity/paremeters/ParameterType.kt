package com.tmpsolutions.data.entity.paremeters

import androidx.room.Entity
import androidx.room.PrimaryKey

typealias ParameterTypeEntity = ParameterType

@Entity
data class ParameterType (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val description : String = "",
    val name : String,
    var metric: String,
    val name2 : String? = null,
    var metric2: String? = null,
    val createdByuser : Boolean = false
)