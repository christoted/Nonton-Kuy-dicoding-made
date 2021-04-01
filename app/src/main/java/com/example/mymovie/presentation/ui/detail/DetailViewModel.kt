package com.example.mymovie.presentation.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mymovie.core.data.FilmRepository
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.core.domain.model.MovieNotEntity
import com.example.mymovie.core.domain.model.TVShowNotEntity
import com.example.mymovie.core.domain.usecase.CatalogueUseCase
import com.example.mymovie.core.vo.Resource

class DetailViewModel @ViewModelInject constructor (private val catalogueUseCase: CatalogueUseCase) : ViewModel() {

    private lateinit var imbdID: String

    fun insertMovie(movie: MovieNotEntity){
        catalogueUseCase.insertMovie(movie)
    }

    fun setSelectedMovie(imbdID: String) {
        this.imbdID = imbdID
    }

    fun setSelectedTVShow(imbdID: String) {
        this.imbdID = imbdID
    }

    fun setBookMarkedMovie(movie: MovieNotEntity, newState: Boolean) {
      //  val newState = !movie.bookmarked
        catalogueUseCase.setBookmarkedMovie(movie, newState)
    }

    fun setBookMarkedTVShow(tvShow: TVShowNotEntity, newState: Boolean) {
//        val newState = !tvShow.bookmarked
        catalogueUseCase.setBookmarkedTVShow(tvShow, newState)
    }


    fun getMovieSelected(): LiveData<Resource<MovieNotEntity>> {

        return catalogueUseCase.getSelectedMovie(imbdID).asLiveData()
    }

    fun getTVShowSelected(): LiveData<Resource<TVShowNotEntity>> {
        return catalogueUseCase.getSelectedTVShow(imbdID).asLiveData()
    }

}