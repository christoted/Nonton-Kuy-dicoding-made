package com.example.mymovie.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class TVShowServiceResponse(
    @field:SerializedName("Response")
    val Response: String,
    @field:SerializedName("Search")
    val TVShowSearch: List<TVShowSearch>,
    @field:SerializedName("totalResults")
    val totalResults: String
)