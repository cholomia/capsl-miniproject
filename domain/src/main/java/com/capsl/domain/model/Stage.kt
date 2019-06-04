package com.capsl.domain.model

data class Stage(
    val id: Long,
    val name: String?,
    val image: String?,
    val active: Boolean = false
)