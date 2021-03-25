package com.example.mymovie.presentation.ui.search

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.mymovie.core.data.remote.ApiResponse
import com.example.mymovie.core.data.remote.response.MovieServiceResponse
import com.example.mymovie.core.domain.usecase.CatalogueUseCase
import kotlinx.coroutines.launch

class SearchViewModel @ViewModelInject constructor(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    val movieSearch: MutableLiveData<ApiResponse<MovieServiceResponse>> = MutableLiveData()

    fun getMovieSearch(query: String) = viewModelScope.launch {
        val movieSearchQuery = catalogueUseCase.getSearchMovie(query).asLiveData()
        movieSearch.postValue(movieSearchQuery.value)
        Log.d("SearchViewModel", "getMovieSearch: $movieSearchQuery")
    }


}