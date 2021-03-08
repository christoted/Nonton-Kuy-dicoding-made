package com.example.mymovie.core.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieSearch(
    @field:SerializedName("Poster")
    val Poster: String,

    @field:SerializedName("Title")
    val Title: String,

    @field:SerializedName("Type")
    val Type: String,

    @field:SerializedName("Year")
    val Year: String,

    @field:SerializedName("imdbID")
    val imdbID: String
): Parcelable