package com.example.mymovie.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieNotEntity(
    var Poster: String,

    var Title: String,

    var Type: String,

    var Year: String,
    var imdbID: String,


    var bookmarked: Boolean = false
): Parcelable