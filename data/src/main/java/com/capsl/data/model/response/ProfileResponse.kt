package com.capsl.data.model.response

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("user_id") val userId: Long,
    @SerializedName("username") val username: String?,
    @SerializedName("first_name") val firstName: String?,
    @SerializedName("last_name") val lastName: String?,
    @SerializedName("clash_royale_tag") val clashRoyaleTag: String?,
    @SerializedName("image") val image: String?
)