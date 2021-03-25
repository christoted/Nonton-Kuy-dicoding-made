package com.example.mymovie.presentation.ui.search

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.mymovie.core.data.remote.ApiResponse
import com.example.mymovie.core.data.remote.response.MovieServiceResponse
import com.example.mymovie.core.domain.usecase.CatalogueUseCase
import com.example.mymovie.core.vo.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchViewModel @ViewModelInject constructor(private val catalogueUseCase: CatalogueUseCase): ViewModel() {

    val movieSearch: MutableLiveData<ApiResponse<MovieServiceResponse>> = MutableLiveData()

    fun getMovieSearch() = viewModelScope.launch {
        val movieSearchQuery = catalogueUseCase.getSearchMovie("Avenger", "2").asLiveData()
        movieSearch.postValue(movieSearchQuery.value)
    }

    fun getMovieSearchWithoutSuspend(query: String, page: String): LiveData<ApiResponse<MovieServiceResponse>> {
        return catalogueUseCase.getSearchMovieWithoutSuspend(query, page).asLiveData()
    }


    private fun checkResponse(response: Response<MovieServiceResponse>): Resource<MovieServiceResponse> {
        if (response.isSuccessful) {
            response.body().let {
                return Resource.success(it)
            }
        }

        return Resource.error(response.message(), null)
    }


}