package com.example.mymovie.core.data.remote.api

import androidx.lifecycle.MutableLiveData
import com.example.mymovie.core.data.remote.ApiResponse
import com.example.mymovie.core.data.remote.response.MovieServiceResponse
import com.example.mymovie.core.data.remote.response.TVShowServiceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CatalogueApi {
    @GET("?apikey=99182b8c&s=*hero*&page=1")
    suspend fun getMovie(): MovieServiceResponse

    @GET("?apikey=99182b8c&s=*panda*&page=1")
    suspend fun getTVShow(): TVShowServiceResponse

    @GET("?apikey=99182b8c")
    suspend fun getSearchMovie(
        @Query("s") query: String,
        @Query("page") page: String
    ): MovieServiceResponse
}