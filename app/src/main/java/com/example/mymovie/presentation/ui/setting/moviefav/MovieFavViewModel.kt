package com.example.mymovie.presentation.ui.setting.moviefav

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagedList
import com.example.mymovie.core.data.FilmRepository
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.domain.model.MovieNotEntity
import com.example.mymovie.core.domain.usecase.CatalogueUseCase
import com.example.mymovie.core.vo.Resource

class MovieFavViewModel @ViewModelInject constructor(private val catalogueUseCase: CatalogueUseCase) : ViewModel() {
    fun getMovieSaved(): LiveData<List<MovieNotEntity>> = catalogueUseCase.getBookmarkedMovie().asLiveData()
}