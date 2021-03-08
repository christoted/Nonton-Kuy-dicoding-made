package com.example.mymovie.core.utils

import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.core.data.remote.response.MovieResponse
import com.example.mymovie.core.data.remote.response.TVShowResponse

object FakeData {
    fun generateFakeMovies() : List<Movie> {
        val listMovies = ArrayList<Movie>()

        listMovies.add(Movie("https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg", "Big Hero 6", "Action, Sci-fi", "2014", "tt2245084", false))
        listMovies.add(Movie("M02", "Avengers: Infinity War", "Action, Crime", "https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SX300.jpg", "21 Maret 2018"))
        listMovies.add(Movie("M03", "Avengers: Endgame", "Action", "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg", "22 Maret 2019"))
        listMovies.add(Movie("M04", "Captain America: The First Avenger", "Action, Comedy", "https://m.media-amazon.com/images/M/MV5BMTYzOTc2NzU3N15BMl5BanBnXkFtZTcwNjY3MDE3NQ@@._V1_SX300.jpg", "23 Maret 2021"))
        listMovies.add(Movie("M05", "Avengers: Age of Ultron", "Comedy, Sci-fi", "https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg", "24 Maret 2021"))
        listMovies.add(Movie("M06", "The Avengers", "Comedy, Family", "https://m.media-amazon.com/images/M/MV5BYWE1NTdjOWQtYTQ2Ny00Nzc5LWExYzMtNmRlOThmOTE2N2I4XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_SX300.jpg", "25 Maret 2021"))
        listMovies.add(Movie("M07", "The Toxic Avenger", "Horror", "https://m.media-amazon.com/images/M/MV5BNzViNmQ5MTYtMmI4Yy00N2Y2LTg4NWUtYWU3MThkMTVjNjk3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "26 Maret 2021"))
        listMovies.add(Movie("M08", "The Avengers: Earth's Mightiest Heroes", "Crime, politic", "https://m.media-amazon.com/images/M/MV5BYzA4ZjVhYzctZmI0NC00ZmIxLWFmYTgtOGIxMDYxODhmMGQ2XkEyXkFqcGdeQXVyNjExODE1MDc@._V1_SX300.jpg", "27 Maret 2021"))
        listMovies.add(Movie("M09", "Ultimate Avengers: The Movie", "Fight, Action", "https://m.media-amazon.com/images/M/MV5BMTYyMjk0NTMwMl5BMl5BanBnXkFtZTgwNzY0NjAwNzE@._V1_SX300.jpg", "28 Maret 2021"))
        listMovies.add(Movie("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Hero", "Action, Fight", "1992", "tt0104412"))



        return listMovies
    }

    fun generateFakeTVShows() : List<TvShow> {
        val listTvShow = ArrayList<TvShow>()

        listTvShow.add(TvShow("TV01", "Kung Fu Panda","Family, Fun", "2008", "tt0441773", false))
        listTvShow.add(TvShow("TV02", "Kung Fu Panda 2","Action", "https://m.media-amazon.com/images/M/MV5BMjI3ODU0OTQ1MV5BMl5BanBnXkFtZTgwNzI0MTQ2MzE@._V1_SX300.jpg", "2 April 2021"))
        listTvShow.add(TvShow("TV03", "Heroes","Serial, TVShow", "https://m.media-amazon.com/images/M/MV5BMWQ2MjQ0OTctMWE1OC00NjZjLTk3ZDAtNTk3NTZiYWMxYTlmXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "3 April 2021"))
        listTvShow.add(TvShow("TV04", "Hero","Horror", "https://m.media-amazon.com/images/M/MV5BNjdhOGY1OTktYWJkZC00OGY5LWJhY2QtZmQzZDA2MzY5MmNmXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg", "4 April 2021"))
        listTvShow.add(TvShow("TV05", "Kelly's Heroe","Crime, Thriller", "https://m.media-amazon.com/images/M/MV5BMzAyNDUwYzUtN2NlMC00ODliLWExMjgtMGMzNmYzZmUwYTg1XkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_SX300.jpg", "5 April 2021"))
        listTvShow.add(TvShow("TV06", "My Hero Academia","Crime, Drama", "https://m.media-amazon.com/images/M/MV5BNmQzYmE2MGEtZjk4YS00YmVjLWEwZWMtODRkMjc4MTM5N2I3XkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg", "6 April 2021"))
        listTvShow.add(TvShow("TV07", "Heroes Reborn","Action", "https://m.media-amazon.com/images/M/MV5BNDg2NTI5OTYzOV5BMl5BanBnXkFtZTgwMzI0MzA1NjE@._V1_SX300.jpg", "7 April 2021"))
        listTvShow.add(TvShow("TV08", "Starship","Drama", "https://m.media-amazon.com/images/M/MV5BOWNiNzRlOWMtNzY2Yi00M2MzLWE0MGEtYzM0NmZhODk3NjUyXkEyXkFqcGdeQXVyNDc2NjEyMw@@._V1_SX300.jpg", "8 April 2021"))
        listTvShow.add(TvShow("TV09", "Local Hero","Horror, Drama", "https://m.media-amazon.com/images/M/MV5BODhiMmM3YzQtZjMwNy00YTdkLTkwOTItZDhjYWE1ZTVlNmExXkEyXkFqcGdeQXVyMjI4MjA5MzA@._V1_SX300.jpg", "9 April 2021"))
        listTvShow.add(TvShow("TV10", "Hero","Action, Crime", "https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "10 April 2021"))

        return listTvShow
    }

    fun generatesRemoteDummyMovie() : List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(MovieResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Big Hero 6", "Movie", "2014", "tt2245084"))
        movies.add(MovieResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Heroes", "Movie", "2017", "TT55555"))
        movies.add(MovieResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Big Hero 6", "Movie", "2019", "TT12345"))
        movies.add(MovieResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Heroes", "Movie", "2017", "TT55555"))
        movies.add(MovieResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Big Hero 6", "Movie", "2019", "TT12345"))
        movies.add(MovieResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Heroes", "Movie", "2017", "TT55555"))
        movies.add(MovieResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Big Hero 6", "Movie", "2019", "TT12345"))
        movies.add(MovieResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Heroes", "Movie", "2017", "TT55555"))
        movies.add(MovieResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Big Hero 6", "Movie", "2019", "TT12345"))
        movies.add(MovieResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Heroes", "Movie", "2017", "TT55555"))
        return movies
    }

    fun generateRemoteDummyTVShow() : List<TVShowResponse> {
        val tvShow = ArrayList<TVShowResponse>()

        tvShow.add(TVShowResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Kung Fu Panda", "TV Show", "2008", "tt0441773"))
        tvShow.add(TVShowResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Kung Fu Panda 2", "TV Show", "2017", "TT55555"))
        tvShow.add(TVShowResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Kung Fu Panda", "TV Show", "2019", "TT12345"))
        tvShow.add(TVShowResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Kung Fu Panda 2", "TV Show", "2017", "TT55555"))
        tvShow.add(TVShowResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Kung Fu Panda", "TV Show", "2019", "TT12345"))
        tvShow.add(TVShowResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Kung Fu Panda 2", "TV Show", "2017", "TT55555"))
        tvShow.add(TVShowResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Kung Fu Panda", "TV Show", "2019", "TT12345"))
        tvShow.add(TVShowResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Kung Fu Panda 2", "TV Show", "2017", "TT55555"))
        tvShow.add(TVShowResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Kung Fu Panda", "TV Show", "2019", "TT12345"))
        tvShow.add(TVShowResponse("https://m.media-amazon.com/images/M/MV5BMTYyMDk0OWItZWQxYy00YzFkLWIwNDctYTYxODU5Zjk3MjAyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Kung Fu Panda 2", "TV Show", "2017", "TT55555"))
        return tvShow
    }


}