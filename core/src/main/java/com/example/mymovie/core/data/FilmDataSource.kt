package com.example.mymovie.core.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.core.vo.Resource

interface FilmDataSource {
    //Pagination
    fun getAllMovie() : LiveData<Resource<List<Movie>>>

    //Pagination
    fun getAllTVShow() : LiveData<Resource<List<TvShow>>>

    fun getSelectedMovie(imdbID : String) : LiveData<Resource<Movie>>

    fun getSelectedTVShow(imdbID: String) : LiveData<Resource<TvShow>>

    fun setBookmarkedMovie(movie: Movie, newState: Boolean)

    fun setBookmarkedTVShow(tvShow: TvShow, newState: Boolean)

    //Pagination
    fun getBookmarkedTVShow(): LiveData<List<TvShow>>
    //Pagination
    fun getBookmarkedMovie(): LiveData<List<Movie>>
}