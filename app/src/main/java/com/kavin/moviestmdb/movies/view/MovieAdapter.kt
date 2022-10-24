package com.kavin.moviestmdb.movies.view

import com.kavin.moviestmdb.BuildConfig
import com.kavin.moviestmdb.R
import com.kavin.moviestmdb.movies.data.Movie
import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


/**
 * Created by Kavin on 19/8/2021.
 */

class MovieAdapter : PagingDataAdapter<Movie, RecyclerView.ViewHolder>(MovieModelComparator) {

    private lateinit var listener: OnItemClick

    fun setListener(mOnItemClick: OnItemClick) {
        listener = mOnItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_view, parent, false)
        return MovieViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as MovieViewHolder
        val movie = getItem(position)
        movie?.poster_path?.let {
            Glide.with(viewHolder.itemView.context)
                    .load(Uri.parse("${BuildConfig.IMAGE_URL}$it"))
                    .into(viewHolder.ivPoster)
            viewHolder.ivPoster.setOnClickListener { listener.onMovieClicked(movie) }
        }
    }


    inner class MovieViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivPoster: ImageView = itemView.findViewById(R.id.movieImg) as ImageView
    }

    interface OnItemClick {
        fun onMovieClicked(movieEntity: Movie)
    }


    companion object {
        private val MovieModelComparator = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

}
