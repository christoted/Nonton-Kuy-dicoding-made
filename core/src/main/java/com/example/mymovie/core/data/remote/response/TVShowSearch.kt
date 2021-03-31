package com.example.mymovie.core.data.remote.response

import androidx.annotation.Keep

@Keep
data class TVShowSearch(
    val Poster: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbID: String
)