package com.tmpsolutions.domain.model.parameters

import com.tmpsolutions.domain.model.parameters.CommonParameters.ammonia
import com.tmpsolutions.domain.model.parameters.CommonParameters.calcium
import com.tmpsolutions.domain.model.parameters.CommonParameters.gh
import com.tmpsolutions.domain.model.parameters.CommonParameters.kh
import com.tmpsolutions.domain.model.parameters.CommonParameters.magnesium
import com.tmpsolutions.domain.model.parameters.CommonParameters.nitrate
import com.tmpsolutions.domain.model.parameters.CommonParameters.nitrite
import com.tmpsolutions.domain.model.parameters.CommonParameters.ph
import com.tmpsolutions.domain.model.parameters.CommonParameters.phosphate
import com.tmpsolutions.domain.model.parameters.CommonParameters.potassium
import com.tmpsolutions.domain.model.parameters.CommonParameters.salinity
import com.tmpsolutions.domain.model.parameters.CommonParameters.temperature


object CommonParameters {
    val ammonia = ParameterType(
        id = AquariumParameterTypeID.AMMONIA,
        name = "Amonia",
        metric = "ppm",
        name2 = "Concentração de amonia",
        metric2 = "?",
    )

    val salinity = ParameterType(
        id = AquariumParameterTypeID.SALINITY,
        name = "Salinity",
        metric = "SG"
    )

    val ph = ParameterType(
        id = AquariumParameterTypeID.PH,
        name = "PH",
        metric = ""
    )

    val kh = ParameterType(
        id = AquariumParameterTypeID.KH,
        name = "KH",
        metric = "°dKH"
    )

    val gh = ParameterType(
        id = AquariumParameterTypeID.GH,
        name = "GH",
        metric = "°dH"
    )

    val nitrite =  ParameterType(
        id = AquariumParameterTypeID.NITRITE,
        name = "Nitrite",
        metric = "°dH"
    )

    val nitrate = ParameterType(
        id = AquariumParameterTypeID.NITRATE,
        name = "Nitrato",
        metric = "°dH"
    )

    val temperature = ParameterType(
        id = AquariumParameterTypeID.TEMPERATURE,
        name = "GH",
        metric = "°dH"
    )

    val calcium = ParameterType(
        id = AquariumParameterTypeID.CALCIUM,
        name = "Calcio",
        metric = "mg/L"
    )

    val magnesium = ParameterType(
        id = AquariumParameterTypeID.MAGNESIUM,
        name = "Magnesium",
        metric = "mg/L"
    )

    val phosphate = ParameterType(
        id = AquariumParameterTypeID.PHOSPHATE,
        name = "Phosphate",
        metric = "mg/L"
    )

    val potassium = ParameterType(
        id = AquariumParameterTypeID.POTASSIUM,
        name = "Potassium",
        metric = "mg/L"
    )
}

val parameters = listOf(
    ammonia, salinity, ph, kh, gh, nitrite, nitrate, temperature, calcium, magnesium, phosphate, potassium
)

object AquariumParameterTypeID {
    const val PH = 0
    const val TEMPERATURE = 1
    const val AMMONIA = 2
    const val NITRITE = 3
    const val NITRATE = 4
    const val SPECIFIC_GRAVITY = 5
    const val SALINITY = 6
    const val GH = 7
    const val KH = 8
    const val CALCIUM = 9
    const val MAGNESIUM = 10
    const val PHOSPHATE = 11
    const val POTASSIUM = 12
}