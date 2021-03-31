package com.example.mymovie.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovie.core.data.remote.response.MovieSearch
import com.example.mymovie.core.domain.model.MovieNotEntity
import com.example.mymovie.databinding.FragmentSearchBinding
import com.example.mymovie.databinding.ItemSearchBinding
import kotlinx.coroutines.withContext

class SearchAdapter(private val itemListener: MovieSearchItemListener): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    val listMoviesSearch = ArrayList<MovieSearch>()

    fun setMoviesSearch(movies: List<MovieSearch>) {
        listMoviesSearch.clear()
        listMoviesSearch.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val movieSearch = listMoviesSearch[position]
        holder.bind(movieSearch)
    }

    override fun getItemCount(): Int = listMoviesSearch.size


    inner class SearchViewHolder(private val binding : ItemSearchBinding): RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                itemListener.onItemClicked(adapterPosition)
            }
        }

        fun bind(movies: MovieSearch) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(movies.Poster)
                    .into(imageViewSearch)

                titleSearch.text = movies.Title
                imbdIdSearch.text = movies.imdbID
                yearSearch.text = movies.Year
            }
        }
    }
}