package com.example.mymovie.core.data.remote.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MovieServiceResponse(
    @field:SerializedName("Response")
    val Response: String,
    @field:SerializedName("Search")
    val Search: List<MovieSearch>,
    @field:SerializedName("totalResults")
    val totalResults: String
)