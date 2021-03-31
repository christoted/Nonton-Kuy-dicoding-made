package com.example.mymovie.core.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    val Poster: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbID: String
) : Parcelable