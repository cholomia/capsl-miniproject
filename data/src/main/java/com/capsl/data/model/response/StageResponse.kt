package com.capsl.data.model.response

import com.google.gson.annotations.SerializedName

data class StageResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String?,
    @SerializedName("is_active") val isActive: Boolean = false
)