package com.capsl.domain.usecase

import com.capsl.domain.model.Stage
import io.reactivex.Single

interface StageUseCase {

    fun getStageList(): Single<List<Stage>>

}