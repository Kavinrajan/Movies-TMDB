package com.kavin.moviestmdb.detail.view

import com.kavin.moviestmdb.R
import com.kavin.moviestmdb.base.BaseFragment
import com.kavin.moviestmdb.detail.data.TrailerRemote
import com.kavin.moviestmdb.movies.view.MoviesViewModel
import com.kavin.moviestmdb.movies.view.MoviesViewModel.Companion.POSTER_BASE_URL
import com.kavin.moviestmdb.movies.view.MoviesViewModel.Companion.YOUTUBE_APP_URI
import com.kavin.moviestmdb.movies.view.MoviesViewModel.Companion.YOUTUBE_WEB_URI
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

/**
 * Created by Kavin on 19/8/2021.
 */
class MoreDetailFragment : BaseFragment<MoviesViewModel>(), TrailerAdapter.TrailerAdapterListener {

    @Inject
    internal lateinit var mViewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var mLinearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var mTrailerAdapter: TrailerAdapter

    override fun getLayoutId(): Int = R.layout.fragment_detail
    override fun getLifeCycleOwner(): LifecycleOwner = this

    override val viewModel by lazy {
        ViewModelProvider(requireActivity(), mViewModelFactory).get(MoviesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mTrailerAdapter.setListener(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    fun initUI() {
        recycler_trailer.setHasFixedSize(true)
        recycler_trailer.layoutManager = mLinearLayoutManager
        recycler_trailer.itemAnimator = DefaultItemAnimator()
        recycler_trailer.adapter = mTrailerAdapter
        renderMovieDetails()
    }

    private fun renderMovieDetails() {
        viewModel.getSelectedMovie()?.apply {
            tv_title.text = title
            tv_plot.text = overview
            tv_rating.text = vote_average.toString()
            tv_release_date.text = String.format(getString(R.string.released_in), release_date)
            tv_votes_count.text = String.format(getString(R.string.votes_count), vote_count.toString())
            rating_bar.rating = (vote_average / 2).toFloat()
            Glide.with(requireActivity())
                    .load("$POSTER_BASE_URL${poster_path}")
                    .into(img_poster)
            img_like.setOnClickListener { viewModel.updateLikeStatus(this) }
            viewModel.getLikeState(id)
            viewModel.fetchMovieTrailers(id)
        }
    }

    override fun renderViewState(data: Any) {
        when (data) {
            is MoreDetailViewState.MessageRes -> showMessage(getString(data.resId))
            is MoreDetailViewState.LikeState -> renderLikeState(data.isLiked)
            is MoreDetailViewState.TrailersFetchedSuccess -> renderTrailers(data.trailers)
            is MoreDetailViewState.TrailersFetchedError -> renderFetchingTrailerError()
        }
    }

    private fun renderFetchingTrailerError() {
        trailers_loading.visibility = View.GONE
        showMessage(getString(R.string.fetch_trailers_error))
    }

    private fun renderTrailers(trailers: List<TrailerRemote>) {
        trailers_loading.visibility = View.GONE
        mTrailerAdapter.addItems(trailers)
    }

    private fun renderLikeState(isLiked: Boolean) {
        if (isLiked) R.string.movie_liked else R.string.movie_disliked
        img_like.setImageResource(if (isLiked) R.drawable.like else R.drawable.dislike)
    }

    override fun onTrailerClicked(trailerRemote: TrailerRemote) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("$YOUTUBE_APP_URI${trailerRemote.key}"))
            startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("$YOUTUBE_WEB_URI${trailerRemote.key}"))
            startActivity(intent)
        }
    }

}