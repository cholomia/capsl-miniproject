package com.capsl.miniproject.util.viewmodel

import androidx.lifecycle.LiveData
import com.capsl.domain.sealedclass.Resource
import com.capsl.miniproject.util.livedata.SingleLiveEvent
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class SingleViewModel<ResultType> : BaseViewModel() {

    private val result = SingleLiveEvent<Resource<ResultType>>()

    fun getResult(): LiveData<Resource<ResultType>> = result

    protected fun execute(single: Single<ResultType>) {
        addDisposable(single
            .doOnSubscribe { result.postValue(Resource.Loading()) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(
                { result.postValue(Resource.Success(it)) },
                { result.postValue(Resource.Error(it)) }
            ))
    }

}