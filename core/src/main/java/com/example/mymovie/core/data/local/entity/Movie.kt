package com.example.mymovie.core.data.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "movieentities")
@Parcelize
data class Movie(
    @ColumnInfo(name = "poster")
    var Poster: String,

    @ColumnInfo(name = "title")
    var Title: String,

    @ColumnInfo(name = "type")
    var Type: String,

    @ColumnInfo(name = "year")
    var Year: String,
    @PrimaryKey
    @ColumnInfo(name = "imbdid")
    var imdbID: String,

    @ColumnInfo(name = "bookmarked")
    var bookmarked: Boolean = false
) : Parcelable
