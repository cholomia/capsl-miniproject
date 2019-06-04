package com.capsl.domain.model

data class Profile(
    val userId: Long,
    val username: String?,
    val firstName: String?,
    val lastName: String?,
    val clashRoyaleTag: String?,
    val image: String?
) {

    val fullName: String
    get() = "${firstName.orEmpty()} ${lastName.orEmpty()}"

}