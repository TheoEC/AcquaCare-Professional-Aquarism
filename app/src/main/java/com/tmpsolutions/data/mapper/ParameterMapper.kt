package com.tmpsolutions.data.mapper

import com.tmpsolutions.data.entity.paremeters.MeasurementEntity
import com.tmpsolutions.data.entity.paremeters.ParameterTypeEntity
import com.tmpsolutions.domain.model.parameters.MeasurementDomain
import com.tmpsolutions.domain.model.parameters.ParameterTypeDomain

fun ParameterTypeEntity.toDomain() = ParameterTypeDomain(
    id = id,
    name = name,
    description = description,
    metric = metric,
    name2 = name2,
    metric2 = metric2,
    createdByuser = createdByuser
)

fun ParameterTypeDomain.toEntity() = ParameterTypeEntity(
    id = id,
    name = getParameterName(),
    description = description,
    metric = metric,
    name2 = name2,
    metric2 = metric2,
    createdByuser = createdByuser
)

fun MeasurementEntity.toDomain() = MeasurementDomain(
    date = date,
    value = value,
    value2 = value2
)