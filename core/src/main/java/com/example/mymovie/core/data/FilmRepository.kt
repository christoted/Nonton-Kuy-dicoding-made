package com.example.mymovie.core.data

import android.util.Log
import androidx.lifecycle.asLiveData
import androidx.paging.PagedList
import com.example.mymovie.core.data.local.LocalDataSource
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.core.data.remote.ApiResponse
import com.example.mymovie.core.data.remote.RemoteDataSource
import com.example.mymovie.core.data.remote.response.MovieServiceResponse
import com.example.mymovie.core.data.remote.response.TVShowServiceResponse
import com.example.mymovie.core.utils.DataMapper
import com.example.mymovie.core.domain.model.MovieNotEntity
import com.example.mymovie.core.domain.model.TVShowNotEntity
import com.example.mymovie.core.domain.repository.ICatalogueRepository
import com.example.mymovie.core.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmRepository @Inject constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) :

    ICatalogueRepository {

//    companion object {
//        @Volatile
//        private var instance: FilmRepository? = null
//
//        fun getInstance(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource) : FilmRepository =
//            instance ?: synchronized(this) {
//                instance ?: FilmRepository(remoteDataSource, localDataSource)
//            }
//    }

    override fun getAllMovie(): Flow<Resource<List<MovieNotEntity>>> {
        return object : NetworkBoundResource<List<MovieNotEntity>, MovieServiceResponse>() {
            override fun loadFromDB(): Flow<List<MovieNotEntity>> {

                val flowPagedListMovieNotEntity = localDataSource.getAllMovies().map {
                    DataMapper.mapEntitiesToDomainMovie(it)
                }

                return flowPagedListMovieNotEntity
            }

            override fun shouldFetch(data: List<MovieNotEntity>): Boolean {
                return data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<MovieServiceResponse>> {
               return remoteDataSource.getAllMovies()
            }

            override suspend fun saveCallForResult(body: MovieServiceResponse) {
                val movieList = ArrayList<Movie>()

                val movies = body.Search

                for ( movie in movies) {
                    val movie = Movie(movie.Poster, movie.Title, movie.Type, movie.Year, movie.imdbID, false )
                       movieList.add(movie)
                }
                Log.d("SAVEDMOVIE", "saveCallForResult: $movieList")
                Log.d("SAVEDMOVIE", "saveCallForResult ATAS : ${localDataSource.getAllMovies().asLiveData().value}")
                localDataSource.insertMovie(movieList)
                Log.d("SAVEDMOVIE", "saveCallForResult BAWAH: ${localDataSource.getAllMovies().asLiveData().value}")

                Log.d("SAVEDMOVIE", "saveCallForResult TVSHOW BAWAH : ${localDataSource.getAllTVShow().asLiveData().value}")
            }

        }.asFlow()
    }


    override fun getAllTVShow(): Flow<Resource<List<TVShowNotEntity>>> {
        return object : NetworkBoundResource<List<TVShowNotEntity>, TVShowServiceResponse>() {
            override fun loadFromDB(): Flow<List<TVShowNotEntity>> {

                val config = PagedList.Config.Builder()
                    .setPageSize(4)
                    .setInitialLoadSizeHint(4)
                    .setEnablePlaceholders(false)
                    .build()

                val flowPagedListTVShowNotEntity = localDataSource.getAllTVShow().map {
                    DataMapper.mapEntitiesToDomainTVShow(it)
                }

               return flowPagedListTVShowNotEntity
            }

            override fun shouldFetch(data: List<TVShowNotEntity>): Boolean {
                return data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<TVShowServiceResponse>> {
                return remoteDataSource.getAllTVShows()
            }

            override suspend fun saveCallForResult(body: TVShowServiceResponse) {
                val listTVShow = ArrayList<TvShow>()

                val tvShows = body.TVShowSearch

                for ( tvShow in tvShows) {
                    val tvShow = TvShow(tvShow.Poster, tvShow.Title, tvShow.Type, tvShow.Year, tvShow.imdbID, false)
                    listTVShow.add(tvShow)
                }
                Log.d("TEST12345", "saveCallForResult: ${localDataSource.getAllTVShow().asLiveData().value}")
                localDataSource.insertTVShow(listTVShow)
            }

        }.asFlow()
    }

    override fun getSelectedMovie(imdbID: String): Flow<Resource<MovieNotEntity>> {
        return object : NetworkBoundResource<MovieNotEntity, MovieServiceResponse>() {
            override fun loadFromDB(): Flow<MovieNotEntity> {

                val selectedMovie = localDataSource.getMovieByImbdID(imdbID).map {
                    DataMapper.mapEntitiesToDomainSelectedMovie(it)
                }

                return selectedMovie
            }

            override fun shouldFetch(data: MovieNotEntity): Boolean {
                return data.imdbID.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<MovieServiceResponse>> {
                return remoteDataSource.getAllMovies()
            }

            override suspend fun saveCallForResult(body: MovieServiceResponse) {
                val listMovie = ArrayList<Movie>()

                val movies = body.Search

                for ( movie in movies) {
                    val movie = Movie(movie.Poster, movie.Title, movie.Type, movie.Year, movie.imdbID, false)
                    listMovie.add(movie)
                }

                localDataSource.insertMovie(listMovie)
            }

        }.asFlow()
    }

    override fun getSelectedTVShow(imdbID: String): Flow<Resource<TVShowNotEntity>> {
        return object : NetworkBoundResource<TVShowNotEntity, TVShowServiceResponse>() {
            override fun loadFromDB(): Flow<TVShowNotEntity> {

                val selectedTVShow = localDataSource.getTVShowByImbdID(imdbID).map {
                    DataMapper.mapEntitiesToDomainSelectedTVShow(it)
                }

                return selectedTVShow
            }

            override fun shouldFetch(data: TVShowNotEntity): Boolean {
                return data.imdbID.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<TVShowServiceResponse>> {
                return remoteDataSource.getAllTVShows()
            }

            override suspend fun saveCallForResult(body: TVShowServiceResponse) {
                val listTVShow = ArrayList<TvShow>()
                val tvShows = body.TVShowSearch

                for ( tvShow in tvShows) {
                    val tvShow = TvShow(tvShow.Poster, tvShow.Title, tvShow.Type, tvShow.Year, tvShow.imdbID, false)
                    listTVShow.add(tvShow)
                }

                localDataSource.insertTVShow(listTVShow)
            }

        }.asFlow()
    }


    override fun setBookmarkedMovie(movie: MovieNotEntity, newState: Boolean) {
        val movieNotEntity = DataMapper.domainToEntityMovie(movie)
        GlobalScope.launch(Dispatchers.IO) {
            localDataSource.setBookmarkedMovie(movieNotEntity, newState)
        }
    }

    override fun setBookmarkedTVShow(tvShow: TVShowNotEntity, newState: Boolean) {
        val tvShowEntity = DataMapper.domainToEntityTVShow(tvShow)
        GlobalScope.launch(Dispatchers.IO) {
            localDataSource.setBookmarkedTVShow(tvShowEntity, newState)
        }
    }

    override fun getBookmarkedTVShow(): Flow<List<TVShowNotEntity>> {

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        val flowPagedListBookmarkedTVShowNotEntity = localDataSource.getBookmarkedTVShow().map {
            DataMapper.mapEntitiesToDomainTVShow(it)
        }


        return flowPagedListBookmarkedTVShowNotEntity
    }

    override fun getBookmarkedMovie(): Flow<List<MovieNotEntity>> {

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        val flowPagedListBookmarkedMovieNotEntity = localDataSource.getBookmarkedMovie().map {
            DataMapper.mapEntitiesToDomainMovie(it)
        }

        return flowPagedListBookmarkedMovieNotEntity
    }

    override suspend fun getSearchedMovie(query: String): Flow<ApiResponse<MovieServiceResponse>> {

        return remoteDataSource.getSearchMovies(query)
    }

}