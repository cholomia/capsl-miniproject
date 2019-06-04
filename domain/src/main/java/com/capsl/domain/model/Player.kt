package com.capsl.domain.model

data class Player(
    val id: Long,
    val profile: Profile?,
    val isSelected: Boolean = false
)