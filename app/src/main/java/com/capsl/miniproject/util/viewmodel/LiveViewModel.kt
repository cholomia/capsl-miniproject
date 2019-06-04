package com.capsl.miniproject.util.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.capsl.domain.sealedclass.Resource
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class LiveViewModel<ResultType> : BaseViewModel() {

    protected val result = MutableLiveData<Resource<ResultType>>()

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