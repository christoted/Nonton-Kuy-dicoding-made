package com.example.mymovie.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.mymovie.core.data.remote.ApiResponse
import com.example.mymovie.core.data.remote.response.MovieServiceResponse
import com.example.mymovie.core.domain.model.MovieNotEntity
import com.example.mymovie.core.domain.model.TVShowNotEntity
import com.example.mymovie.core.domain.repository.ICatalogueRepository
import com.example.mymovie.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatalogueInteractor @Inject constructor(private val iCatalogueRepository: ICatalogueRepository):
    CatalogueUseCase {
    override fun getAllMovie(): Flow<Resource<List<MovieNotEntity>>> = iCatalogueRepository.getAllMovie()

    override fun getAllTVShow(): Flow<Resource<List<TVShowNotEntity>>> = iCatalogueRepository.getAllTVShow()

    override fun getSelectedMovie(imdbID: String): Flow<Resource<MovieNotEntity>> = iCatalogueRepository.getSelectedMovie(imdbID)

    override fun getSelectedTVShow(imdbID: String): Flow<Resource<TVShowNotEntity>> = iCatalogueRepository.getSelectedTVShow(imdbID)

    override fun setBookmarkedMovie(movie: MovieNotEntity, newState: Boolean) {
        iCatalogueRepository.setBookmarkedMovie(movie, newState)
    }

    override fun setBookmarkedTVShow(tvShow: TVShowNotEntity, newState: Boolean) {
        iCatalogueRepository.setBookmarkedTVShow(tvShow, newState)
    }

    override fun getBookmarkedTVShow(): Flow<List<TVShowNotEntity>> = iCatalogueRepository.getBookmarkedTVShow()

    override fun getBookmarkedMovie(): Flow<List<MovieNotEntity>> = iCatalogueRepository.getBookmarkedMovie()

    //Search
    override suspend fun getSearchMovie(query: String): Flow<ApiResponse<MovieServiceResponse>> = iCatalogueRepository.getSearchedMovie(query)

}