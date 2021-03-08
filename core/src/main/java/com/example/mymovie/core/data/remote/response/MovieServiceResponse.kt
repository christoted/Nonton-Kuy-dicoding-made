package com.example.mymovie.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieServiceResponse(
    @field:SerializedName("Response")
    val Response: String,
    @field:SerializedName("Search")
    val Search: List<MovieSearch>,
    @field:SerializedName("totalResults")
    val totalResults: String
)