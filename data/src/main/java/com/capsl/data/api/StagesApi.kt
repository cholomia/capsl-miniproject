package com.capsl.data.api

import com.capsl.data.model.response.BaseListResponse
import com.capsl.data.model.response.StageResponse
import io.reactivex.Single
import retrofit2.http.GET

interface StagesApi {

    @GET("stages")
    fun getStageList(): Single<BaseListResponse<StageResponse>>

}