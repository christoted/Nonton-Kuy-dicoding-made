package com.example.mymovie.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.mymovie.core.domain.model.MovieNotEntity
import com.example.mymovie.core.domain.model.TVShowNotEntity
import com.example.mymovie.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface CatalogueUseCase {
    //Pagination
    fun getAllMovie() : Flow<Resource<List<MovieNotEntity>>>

    //Pagination
    fun getAllTVShow() : Flow<Resource<List<TVShowNotEntity>>>

    fun getSelectedMovie(imdbID : String) : Flow<Resource<MovieNotEntity>>

    fun getSelectedTVShow(imdbID: String) : Flow<Resource<TVShowNotEntity>>

    fun setBookmarkedMovie(movie: MovieNotEntity, newState: Boolean)

    fun setBookmarkedTVShow(tvShow: TVShowNotEntity, newState: Boolean)

    //Pagination
    fun getBookmarkedTVShow(): Flow<List<TVShowNotEntity>>
    //Pagination
    fun getBookmarkedMovie(): Flow<List<MovieNotEntity>>
}