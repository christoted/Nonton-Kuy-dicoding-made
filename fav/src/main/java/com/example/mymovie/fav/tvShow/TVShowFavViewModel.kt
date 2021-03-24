package com.example.mymovie.fav.tvShow

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mymovie.core.domain.model.TVShowNotEntity
import com.example.mymovie.core.domain.usecase.CatalogueUseCase

class TVShowFavViewModel @ViewModelInject constructor (private val catalogueUseCase: CatalogueUseCase) : ViewModel() {
    fun getSavedTVShow(): LiveData<List<TVShowNotEntity>> = catalogueUseCase.getBookmarkedTVShow().asLiveData()

}