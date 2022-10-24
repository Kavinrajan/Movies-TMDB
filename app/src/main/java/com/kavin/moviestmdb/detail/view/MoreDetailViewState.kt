package com.kavin.moviestmdb.detail.view

import com.kavin.moviestmdb.detail.data.TrailerRemote

sealed class MoreDetailViewState {
    object TrailersFetchedError : MoreDetailViewState()
    class TrailersFetchedSuccess(val trailers:  List<TrailerRemote>) : MoreDetailViewState()
    class LikeState(val isLiked: Boolean) : MoreDetailViewState()
    class MessageRes(val resId: Int) : MoreDetailViewState()
}
