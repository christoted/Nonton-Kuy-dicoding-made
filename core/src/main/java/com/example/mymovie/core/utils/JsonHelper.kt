package com.example.mymovie.core.utils

import android.content.Context
import com.example.mymovie.core.data.remote.response.MovieResponse
import com.example.mymovie.core.data.remote.response.TVShowResponse
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName : String) : String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieResponse> {
        val listMovie : ArrayList<MovieResponse> = ArrayList()

        try {
            val responseObject = JSONObject(parsingFileToString("movie.json").toString())
            val listArray = responseObject.getJSONArray("Search")

            for ( i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val imdbID = movie.getString("imdbID")
                val Poster = movie.getString("Poster")
                val Title = movie.getString("Title")
                val Type = movie.getString("Type")
                val Year = movie.getString("Year")

                val movieResponse = MovieResponse(Poster, Title, Type, Year, imdbID)
                listMovie.add(movieResponse)
            }
        } catch (e : IOException) {
            e.printStackTrace()
        }


        return listMovie
    }

    fun loadTVShow(): List<TVShowResponse> {
        val listTVShow : ArrayList<TVShowResponse> = ArrayList()

        try {
            val responseObject = JSONObject(parsingFileToString("tvshow.json").toString())
            val listArray = responseObject.getJSONArray("Search")

            for ( i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val imdbID = tvShow.getString("imdbID")
                val Poster = tvShow.getString("Poster")
                val Title = tvShow.getString("Title")
                val Type = tvShow.getString("Type")
                val Year = tvShow.getString("Year")

                val tvShowResponse = TVShowResponse(Poster, Title, Type, Year, imdbID)
                listTVShow.add(tvShowResponse)
            }

        } catch (e : IOException) {
            e.printStackTrace()
        }

        return listTVShow
    }



}