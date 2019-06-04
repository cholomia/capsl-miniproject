package com.capsl.data.model.response

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("package_id") val packageId: String?
)