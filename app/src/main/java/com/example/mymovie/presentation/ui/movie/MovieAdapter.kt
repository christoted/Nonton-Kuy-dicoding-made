package com.example.mymovie.presentation.ui.movie

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovie.R
import com.example.mymovie.databinding.FragmentMovieBinding
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.databinding.ItemMovieBinding
import com.example.mymovie.core.domain.model.MovieNotEntity
import com.example.mymovie.presentation.ui.detail.DetailActivity


class MovieAdapter(
    val listener : MovieItemListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var listMovie = ArrayList<MovieNotEntity>()

    fun setData(newListData: List<MovieNotEntity>) {
        listMovie.clear()
        listMovie.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)

    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                listener.onMovieItemClicked(adapterPosition)
            }
        }

        fun bind(movie: MovieNotEntity) {
            with(binding) {
                textViewTitleMovie.text = movie.Title
                textViewTitleReleaseDate.text = movie.Year
                Glide.with(itemView.context)
                        .load(movie.Poster)
                        .placeholder(R.drawable.ic_loading)
                        .into(imageViewMovie)


            }
        }
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }
}