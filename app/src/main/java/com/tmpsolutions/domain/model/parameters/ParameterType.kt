package com.tmpsolutions.domain.model.parameters

typealias ParameterTypeDomain = ParameterType

class ParameterType (
    val id : Int,
    val description : String = "",
    private val name : String,
    var metric: String,
    //Some parameters have 2 types of measurement
    val name2 : String? = null,
    var metric2: String? = null,
    val createdByuser : Boolean = false
) {
    //TODO translate
    fun getParameterName(): String {
        with(AquariumParameterTypeID) {
            return when (id) {
                PH -> "pH"
                TEMPERATURE -> "Temperature"
                AMMONIA -> "Ammonia"
                NITRITE -> "Nitrite"
                NITRATE -> "Nitrate"
                SPECIFIC_GRAVITY -> "Specific Gravity"
                SALINITY -> "Salinity"
                GH -> "GH"
                KH -> "KH"
                CALCIUM -> "Calcium"
                MAGNESIUM -> "Magnesium"
                PHOSPHATE -> "Phosphate"
                POTASSIUM -> "Potassium"
                else -> name
            }
        }
    }

}