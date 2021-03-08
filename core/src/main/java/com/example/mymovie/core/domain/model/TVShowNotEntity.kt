package com.example.mymovie.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TVShowNotEntity(
    var Poster: String,

    var Title: String,

    var Type: String,

    var Year: String,
    var imdbID: String,


    var bookmarked: Boolean = false
): Parcelable