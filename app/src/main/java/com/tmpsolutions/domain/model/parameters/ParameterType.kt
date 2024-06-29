package com.tmpsolutions.domain.model.parameters

typealias ParameterTypeDomain = ParameterType

class ParameterType (
    val id : Int,
    val description : String = "",
    val name : String,
    var metric: String,
    //Some parameters have 2 types of measurement
    val name2 : String? = null,
    var metric2: String? = null,
    val createdByuser : Boolean = false
)