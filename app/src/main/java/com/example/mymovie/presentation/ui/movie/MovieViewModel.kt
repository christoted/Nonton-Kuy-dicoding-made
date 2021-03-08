package com.example.mymovie.presentation.ui.movie

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagedList
import com.example.mymovie.core.data.FilmRepository
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.utils.FakeData
import com.example.mymovie.core.domain.model.MovieNotEntity
import com.example.mymovie.core.domain.usecase.CatalogueUseCase
import com.example.mymovie.core.vo.Resource
import com.example.mymovie.presentation.ui.tvshow.TvShowViewModel

class MovieViewModel @ViewModelInject constructor (private val catalogueUseCase: CatalogueUseCase) : ViewModel(){

    companion object {
        val TAG = MovieViewModel::class.java.simpleName
    }

    fun getMovie() : LiveData<Resource<List<MovieNotEntity>>> {
        Log.d("MOVIE1", "getMovie: ${catalogueUseCase.getAllMovie().asLiveData().value?.status}")
        return catalogueUseCase.getAllMovie().asLiveData()
    }

   // val movies = catalogueUseCase.getAllMovie()


}