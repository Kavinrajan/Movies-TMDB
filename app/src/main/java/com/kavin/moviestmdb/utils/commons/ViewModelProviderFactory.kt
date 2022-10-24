

package com.kavin.moviestmdb.utils.commons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Kavin on 19/8/2021.
 */

class ViewModelProviderFactory<V : Any>(private var viewModel: V) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel.javaClass)) {
            return  viewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}