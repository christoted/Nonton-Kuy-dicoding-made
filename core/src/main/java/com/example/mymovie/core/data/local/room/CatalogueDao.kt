package com.example.mymovie.core.data.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import kotlinx.coroutines.flow.Flow

@Dao
interface CatalogueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(listMovie : List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTVShow(listTvShow: List<TvShow>)

    // Pagination
    @Query("SELECT * FROM movieentities")
    fun getAllMovies():  Flow<List<Movie>>

    @Query("SELECT * FROM movieentities WHERE imbdid = :imbdid")
    fun getMovieByImbdID(imbdid: String) : Flow<Movie>

    // Pagination
    @Query("SELECT * FROM movieentities WHERE bookmarked = 1")
    fun getBookmarkedMovie(): Flow<List<Movie>>

    // Pagination
    @Query("SELECT * FROM tvshowentities")
    fun getAllTVShow(): Flow<List<TvShow>>

    @Query("SELECT * FROM tvshowentities WHERE imbdid = :imbdid")
    fun getTVShowByImbdID(imbdid: String): Flow<TvShow>

    // Pagination
    @Query("SELECT * FROM tvshowentities WHERE bookmarked = 1")
    fun getBookmarkedTVshow(): Flow<List<TvShow>>

    // For update state Bookmark
    @Update
    fun updateBookmarkedTVShow(tvShow: TvShow)

    @Update
    fun updateBookmarkedMovie(movie: Movie)

    // Delete if necessary
    @Delete()
    fun deleteMovie(movie: Movie)

    @Delete
    fun deleteTVShow(tvShow: TvShow)
}