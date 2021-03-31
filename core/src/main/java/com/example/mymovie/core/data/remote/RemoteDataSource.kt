package com.example.mymovie.core.data.remote

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.remote.api.CatalogueApi
import com.example.mymovie.core.data.remote.response.MovieResponse
import com.example.mymovie.core.data.remote.response.MovieServiceResponse
import com.example.mymovie.core.data.remote.response.TVShowResponse
import com.example.mymovie.core.data.remote.response.TVShowServiceResponse
import com.example.mymovie.core.utils.EspressoIdlingResource
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val catalogueApi: CatalogueApi) {

    companion object {
        val TAG = RemoteDataSource::class.java.simpleName
    }

    suspend fun getAllTVShows(): Flow<ApiResponse<TVShowServiceResponse>> {
        return flow {
            try {
                val response = catalogueApi.getTVShow()
                val dataArray = response.TVShowSearch

                if (dataArray.isNotEmpty()) {
                    Log.d("OYYY", "getAllTVShow: $response")
                    emit(ApiResponse.success(response))

                }else {
                    emit(ApiResponse.empty<TVShowServiceResponse>("Empty"))
                }
            } catch (e: Exception) {
                emit(ApiResponse.error(e.toString()))
                Log.e( "getAllMovies: ", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllMovies(): Flow<ApiResponse<MovieServiceResponse>> {
        return flow {
            try {
                val response = catalogueApi.getMovie()
                val dataArray = response.Search

                if (dataArray.isNotEmpty()) {
                    Log.d("OYYY", "getAllMovies: $response")
                    emit(ApiResponse.success(response))
                }else {
                    emit(ApiResponse.empty<MovieServiceResponse>("Empty"))
                }
            } catch (e: Exception) {
                emit(ApiResponse.error(e.toString()))
                Log.e( "getAllMovies: ", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getSearchMovies(query: String, page: String): Flow<ApiResponse<MovieServiceResponse>> {
        return flow {
            try {
                val response = catalogueApi.getSearchMovie(query, page)
                val dataArray = response.Search

                if (dataArray.isNotEmpty()) {
                    Log.d("SEARCHMOVIE-REMOTE", "isNotEMpty: $dataArray")
                    emit(ApiResponse.success(response))
                } else {
                    emit(ApiResponse.empty<MovieServiceResponse>("Empty"))
                    Log.d("SEARCHMOVIE-REMOTE", "isEmpty: $dataArray")
                }

            } catch (e: Exception) {
                emit(ApiResponse.error<MovieServiceResponse>(e.toString()))
            }
        }
    }

    fun searchMovies(query: String, page: String): Flow<ApiResponse<MovieServiceResponse>> {

        return flow {
            try {
                val apiServiceMovie = catalogueApi.getSearchMovie(query, page)
                emit(ApiResponse.success(apiServiceMovie))
             } catch (e: Exception) {
                emit(ApiResponse.error<MovieServiceResponse>("Error"))
            }


        }
    }


}