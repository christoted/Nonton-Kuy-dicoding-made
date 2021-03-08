package com.example.mymovie.presentation.ui.tvshow

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagedList
import com.example.mymovie.core.data.FilmRepository
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.core.utils.FakeData
import com.example.mymovie.core.domain.model.TVShowNotEntity
import com.example.mymovie.core.domain.usecase.CatalogueUseCase
import com.example.mymovie.core.vo.Resource

class TvShowViewModel @ViewModelInject constructor (private val catalogueUseCase: CatalogueUseCase) : ViewModel() {

    companion object {
        val TAG = TvShowViewModel::class.java.simpleName
    }

    fun getTVShow() : LiveData<Resource<List<TVShowNotEntity>>> {
        Log.d("TVSHOW1", "getTVShow: ${catalogueUseCase.getAllTVShow().asLiveData().value?.status}")
        return catalogueUseCase.getAllTVShow().asLiveData()
    }

   // val tvShows = catalogueUseCase.getAllTVShow()

}