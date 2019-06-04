package com.capsl.data.usecase

import com.capsl.data.api.StagesApi
import com.capsl.domain.model.Stage
import com.capsl.domain.usecase.StageUseCase
import io.reactivex.Single
import javax.inject.Inject

class StageUseCaseImpl @Inject constructor(
    private val stagesApi: StagesApi
) : StageUseCase {

    /**
     * todo: provide image url
     */
    override fun getStageList(): Single<List<Stage>> = stagesApi.getStageList()
        .map { response ->
            response.results
                .filter { it.isActive }
                .map { Stage(it.id, it.name, "", it.isActive) }
        }

}