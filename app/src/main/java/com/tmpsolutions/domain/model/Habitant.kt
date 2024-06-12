package com.tmpsolutions.domain.model

typealias HabitantDomain = Habitant

data class Habitant(
    val id: Int = 0,
    val aquariumId: Int,
    var taxonomy: AnimalInfoDomain? = null,
    val name: String,
    val qtd: Int,
    val gender: GenderType? = null,
)

enum class GenderType {
    MALE,
    FEMALE,
    HERMAPHRODITE,
    UNKNOWN
}