package com.capsl.miniproject.util.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * This is an extension function that calls to [LiveData.observeNullable].
 * Observes live data and publish nullable data
 */
fun <M : Any, L : LiveData<M?>> LifecycleOwner.observeNullable(liveData: L, observer: (M?) -> Unit = {}) =
    liveData.observe(this, Observer(observer))

/**
 * This is an extension function that calls to [LiveData.observeNonNull].
 * Observes live data but only publish for non-null data
 */
fun <M : Any, L : LiveData<M>> LifecycleOwner.observeNonNull(liveData: L, observer: (M) -> Unit = {}) =
    liveData.observe(this, Observer(observer))