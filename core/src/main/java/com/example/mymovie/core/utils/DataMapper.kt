package com.example.mymovie.core.utils

import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.core.data.remote.response.MovieSearch
import com.example.mymovie.core.domain.model.MovieNotEntity
import com.example.mymovie.core.domain.model.TVShowNotEntity

object DataMapper {
    fun mapEntitiesToDomainMovie(input: List<Movie>) : List<MovieNotEntity> {

        val listMovieNotEntity = ArrayList<MovieNotEntity>()

        input.map {
            val movieNotEntity = MovieNotEntity(it.Poster, it.Title, it.Type, it.Year, it.imdbID, it.bookmarked)
            listMovieNotEntity.add(movieNotEntity)
        }

        return listMovieNotEntity
    }

    fun mapEntitiesToDomainSelectedMovie(input: Movie) = MovieNotEntity(input.Poster, input.Title, input.Type, input.Year, input.imdbID, input.bookmarked)
    fun mapEntitiesToDomainSelectedTVShow(input: TvShow) = TVShowNotEntity(input.Poster, input.Title, input.Type, input.Year, input.imdbID, input.bookmarked)

    fun domainToEntityMovie(it: MovieNotEntity) = Movie(it.Poster, it.Title, it.Type, it.Year, it.imdbID, it.bookmarked)

    fun mapEntitiesToDomainTVShow(input: List<TvShow>) : List<TVShowNotEntity> {

        val listMovieNotEntity = ArrayList<TVShowNotEntity>()

        input.map {
            val tVShowNotEntity = TVShowNotEntity(it.Poster, it.Title, it.Type, it.Year, it.imdbID, it.bookmarked)
            listMovieNotEntity.add(tVShowNotEntity)
        }

        return listMovieNotEntity
    }

    fun domainToEntityTVShow(it: TVShowNotEntity) = TvShow(it.Poster, it.Title, it.Type, it.Year, it.imdbID, it.bookmarked)


    // MovieSearch to MovieNotEntity
    fun mapMovieSearchToMovieNotEntity(input: MovieSearch) = MovieNotEntity(input.Poster, input.Title, input.Type, input.Year, input.imdbID, false)

}