package com.tmpsolutions.domain.model.parameters

import java.util.Date

typealias MeasurementDomain = Measurement

data class Measurement(
    val date: Date,
    val value: Float,
    val value2: Float? = null
)