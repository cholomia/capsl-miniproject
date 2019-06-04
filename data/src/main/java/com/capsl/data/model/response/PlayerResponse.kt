package com.capsl.data.model.response

import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("profile") val profile: ProfileResponse?,
    @SerializedName("is_active") val isSelected: Boolean = false
)