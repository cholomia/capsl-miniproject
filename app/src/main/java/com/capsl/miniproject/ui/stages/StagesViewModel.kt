package com.capsl.miniproject.ui.stages

import com.capsl.domain.model.Stage
import com.capsl.domain.usecase.StageUseCase
import com.capsl.miniproject.util.viewmodel.LiveViewModel
import javax.inject.Inject

class StagesViewModel @Inject constructor(
    private val stageUseCase: StageUseCase
) : LiveViewModel<List<Stage>>() {

    fun getStageList() {
        execute(stageUseCase.getStageList())
    }
}