package com.example.mymovie.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.mymovie.core.data.FilmDataSource
import com.example.mymovie.core.data.NetworkBoundResource
import com.example.mymovie.core.data.local.LocalDataSource
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.core.data.remote.ApiResponse
import com.example.mymovie.core.data.remote.RemoteDataSource
import com.example.mymovie.core.data.remote.response.MovieResponse
import com.example.mymovie.core.data.remote.response.MovieServiceResponse
import com.example.mymovie.core.data.remote.response.TVShowResponse
import com.example.mymovie.core.data.remote.response.TVShowServiceResponse
import com.example.mymovie.core.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//class FakeFilmRepository (
//    private val remoteDataSource: RemoteDataSource,
//    private val localDataSource: LocalDataSource
//) :
//
//    _root_ide_package_.com.example.mymovie.core.data.FilmDataSource {
//
//    override fun getAllMovie(): LiveData<Resource<PagedList<Movie>>> {
//        return object : NetworkBoundResource<PagedList<Movie>, MovieServiceResponse>() {
//            override fun loadFromDB(): LiveData<PagedList<Movie>> {
//
//                val config = PagedList.Config.Builder()
//                    .setEnablePlaceholders(false)
//                    .setInitialLoadSizeHint(4)
//                    .setPageSize(4)
//                    .build()
//
//                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
//            }
//
//            override fun shouldFetch(data: PagedList<Movie>): Boolean {
//                return data.isEmpty()
//            }
//
//            override suspend fun createCall(): LiveData<ApiResponse<MovieServiceResponse>> {
//                return remoteDataSource.getAllMovie()
//            }
//
//            override suspend fun saveCallForResult(body: MovieServiceResponse) {
//                val movieList = ArrayList<Movie>()
//
//                val movies = body.Search
//
//                for (movie in movies) {
//                    val movie = Movie(
//                        movie.Poster,
//                        movie.Title,
//                        movie.Type,
//                        movie.Year,
//                        movie.imdbID,
//                        false
//                    )
//                    movieList.add(movie)
//                }
//
//
//                localDataSource.insertMovie(movieList)
//            }
//
//        }.asLiveData()
//    }
//
//
//    override fun getAllTVShow(): LiveData<Resource<PagedList<TvShow>>> {
//        return object : NetworkBoundResource<PagedList<TvShow>, TVShowServiceResponse>() {
//            override fun loadFromDB(): LiveData<PagedList<TvShow>> {
//
//                val config = PagedList.Config.Builder()
//                    .setPageSize(4)
//                    .setInitialLoadSizeHint(4)
//                    .setEnablePlaceholders(false)
//                    .build()
//
//                return LivePagedListBuilder(localDataSource.getAllTVShow(), config).build()
//            }
//
//            override fun shouldFetch(data: PagedList<TvShow>): Boolean {
//                return data.isEmpty()
//            }
//
//            override suspend fun createCall(): LiveData<ApiResponse<TVShowServiceResponse>> {
//                return remoteDataSource.getAllTVShow()
//            }
//
//            override suspend fun saveCallForResult(body: TVShowServiceResponse) {
//                val listTVShow = ArrayList<TvShow>()
//
//                val tvShows = body.TVShowSearch
//
//                for (tvShow in tvShows) {
//                    val tvShow = TvShow(
//                        tvShow.Poster,
//                        tvShow.Title,
//                        tvShow.Type,
//                        tvShow.Year,
//                        tvShow.imdbID,
//                        false
//                    )
//                    listTVShow.add(tvShow)
//                }
//
//                localDataSource.insertTVShow(listTVShow)
//            }
//
//        }.asLiveData()
//    }
//
//    override fun getSelectedMovie(imdbID: String): LiveData<Resource<Movie>> {
//        return object : NetworkBoundResource<Movie, MovieServiceResponse>() {
//            override fun loadFromDB(): LiveData<Movie> {
//                return localDataSource.getMovieByImbdID(imdbID)
//            }
//
//            override fun shouldFetch(data: Movie): Boolean {
//                return data.imdbID.isEmpty()
//            }
//
//            override suspend fun createCall(): LiveData<ApiResponse<MovieServiceResponse>> {
//                return remoteDataSource.getAllMovie()
//            }
//
//            override suspend fun saveCallForResult(body: MovieServiceResponse) {
//                val listMovie = ArrayList<Movie>()
//
//                val movies = body.Search
//
//                for (movie in movies) {
//                    val movie = Movie(
//                        movie.Poster,
//                        movie.Title,
//                        movie.Type,
//                        movie.Year,
//                        movie.imdbID,
//                        false
//                    )
//                    listMovie.add(movie)
//                }
//
//                localDataSource.insertMovie(listMovie)
//            }
//
//        }.asLiveData()
//    }
//
//    override fun getSelectedTVShow(imdbID: String): LiveData<Resource<TvShow>> {
//        return object : NetworkBoundResource<TvShow, TVShowServiceResponse>() {
//            override fun loadFromDB(): LiveData<TvShow> {
//                return localDataSource.getTVShowByImbdID(imdbID)
//            }
//
//            override fun shouldFetch(data: TvShow): Boolean {
//                return data.imdbID.isEmpty()
//            }
//
//            override suspend fun createCall(): LiveData<ApiResponse<TVShowServiceResponse>> {
//                return remoteDataSource.getAllTVShow()
//            }
//
//            override suspend fun saveCallForResult(body: TVShowServiceResponse) {
//                val listTVShow = ArrayList<TvShow>()
//                val tvShows = body.TVShowSearch
//
//                for (tvShow in tvShows) {
//                    val tvShow = TvShow(
//                        tvShow.Poster,
//                        tvShow.Title,
//                        tvShow.Type,
//                        tvShow.Year,
//                        tvShow.imdbID,
//                        false
//                    )
//                    listTVShow.add(tvShow)
//                }
//
//                localDataSource.insertTVShow(listTVShow)
//            }
//
//        }.asLiveData()
//    }
//
//
//    override fun setBookmarkedMovie(movie: Movie, newState: Boolean) {
//        GlobalScope.launch(Dispatchers.IO) {
//            localDataSource.setBookmarkedMovie(movie, newState)
//        }
//    }
//
//    override fun setBookmarkedTVShow(tvShow: TvShow, newState: Boolean) {
//        GlobalScope.launch(Dispatchers.IO) {
//            localDataSource.setBookmarkedTVShow(tvShow, newState)
//        }
//    }
//
//    override fun getBookmarkedTVShow(): LiveData<PagedList<TvShow>> {
//
//        val config = PagedList.Config.Builder()
//            .setEnablePlaceholders(false)
//            .setInitialLoadSizeHint(4)
//            .setPageSize(4)
//            .build()
//
//
//        return LivePagedListBuilder(localDataSource.getBookmarkedTVShow(), config).build()
//    }
//
//    override fun getBookmarkedMovie(): LiveData<PagedList<Movie>> {
//
//        val config = PagedList.Config.Builder()
//            .setEnablePlaceholders(false)
//            .setInitialLoadSizeHint(4)
//            .setPageSize(4)
//            .build()
//
//        return LivePagedListBuilder(localDataSource.getBookmarkedMovie(), config).build()
//    }
//
//
//}