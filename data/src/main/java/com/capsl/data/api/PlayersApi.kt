package com.capsl.data.api

import com.capsl.data.model.response.BaseListResponse
import com.capsl.data.model.response.PlayerResponse
import io.reactivex.Single
import retrofit2.http.GET

interface PlayersApi {

    @GET("players")
    fun getPlayerList(): Single<BaseListResponse<PlayerResponse>>

}