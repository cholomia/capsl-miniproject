package com.capsl.data.model.response

import com.google.gson.annotations.SerializedName

data class BaseListResponse<T>(
    @SerializedName("count") val count: Long,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<T>
)