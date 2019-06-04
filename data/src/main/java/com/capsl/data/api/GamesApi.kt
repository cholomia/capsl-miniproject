package com.capsl.data.api

import com.capsl.data.model.response.BaseListResponse
import com.capsl.data.model.response.GameResponse
import io.reactivex.Single
import retrofit2.http.GET

interface GamesApi {

    @GET("games")
    fun getGameList(): Single<BaseListResponse<GameResponse>>

}