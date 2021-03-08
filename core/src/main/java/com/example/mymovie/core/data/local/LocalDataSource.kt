package com.example.mymovie.core.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.core.data.local.room.CatalogueDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val catalogueDao: CatalogueDao) {
//    companion object {
//        private var INSTANCE: LocalDataSource? = null
//        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
//            INSTANCE ?: LocalDataSource(catalogueDao)
//    }

    // Movie
    fun getAllMovies(): Flow<List<Movie>> = catalogueDao.getAllMovies()

    suspend fun insertMovie(listMovie: List<Movie>) = catalogueDao.insertMovie(listMovie)

    fun setBookmarkedMovie(movie: Movie, newState: Boolean) {
        movie.bookmarked = newState
        catalogueDao.updateBookmarkedMovie(movie)
    }

    fun getBookmarkedMovie(): Flow<List<Movie>> = catalogueDao.getBookmarkedMovie()

    fun getMovieByImbdID(imbdid: String): Flow<Movie> = catalogueDao.getMovieByImbdID(imbdid)

    fun deleteMovie(movie: Movie) {
        catalogueDao.deleteMovie(movie)
    }

    // TV Show
    fun getAllTVShow(): Flow<List<TvShow>> = catalogueDao.getAllTVShow()

    suspend fun insertTVShow(listTvShow: List<TvShow>) = catalogueDao.insertTVShow(listTvShow)

    fun setBookmarkedTVShow(tvShow: TvShow, newState: Boolean) {
        tvShow.bookmarked = newState
        catalogueDao.updateBookmarkedTVShow(tvShow)
    }

    fun getBookmarkedTVShow(): Flow<List<TvShow>> = catalogueDao.getBookmarkedTVshow()

    fun getTVShowByImbdID(imbdid: String): Flow<TvShow> = catalogueDao.getTVShowByImbdID(imbdid)

    fun deleteTVShow(tvShow: TvShow) {
        catalogueDao.deleteTVShow(tvShow)
    }
}