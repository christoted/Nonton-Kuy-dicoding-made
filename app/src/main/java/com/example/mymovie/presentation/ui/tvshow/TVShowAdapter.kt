package com.example.mymovie.presentation.ui.tvshow

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovie.R
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.core.databinding.ItemTvShowBinding
import com.example.mymovie.core.domain.model.TVShowNotEntity

class TVShowAdapter(
    val listener : TVShowListener
) : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {

    private var listTVShow = ArrayList<TVShowNotEntity>()

    fun setTVShows(tvShows: List<TVShowNotEntity>) {
        if ( listTVShow == null) return
        listTVShow.clear()
        listTVShow.addAll(tvShows)
        notifyDataSetChanged()
    }

    fun getTVShows(): List<TVShowNotEntity> {
        return listTVShow
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val itemTvShowBinding = ItemTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(itemTvShowBinding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val tvShow = listTVShow[position]
        if ( tvShow != null) {
            holder.bind(tvShow)
        }

    }


    inner class TVShowViewHolder ( private val binding : ItemTvShowBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                listener.onTVShowClickedListener(adapterPosition)
            }
        }

        fun bind(tvShow: TVShowNotEntity) {
            with(binding) {
                textViewTitleTvShow.text = tvShow.Title
                textViewTitleReleaseDateTvShow.text = tvShow.Year
                Glide.with(itemView.context)
                        .load(tvShow.Poster)
                        .placeholder(R.drawable.ic_loading)
                        .into(binding.imageViewTvShow)
            }
        }
    }

    override fun getItemCount(): Int {
        return listTVShow.size
    }


}