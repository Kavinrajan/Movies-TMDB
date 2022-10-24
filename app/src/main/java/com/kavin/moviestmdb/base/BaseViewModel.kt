package com.kavin.moviestmdb.base

import com.kavin.moviestmdb.utils.commons.toSingleEvent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Kavin on 19/8/2021.
 */

abstract class BaseViewModel() : ViewModel() {

    private val mUiState = MutableLiveData<Any>()
    open val uiState: LiveData<Any> = mUiState.toSingleEvent()

    fun <T : Any> updateViewState(result: T) {
        mUiState.value = result
    }

}