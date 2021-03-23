package com.example.mymovie.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.mymovie.core.data.local.LocalDataSource
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.core.data.remote.RemoteDataSource
import com.example.mymovie.core.data.remote.response.MovieResponse
import com.example.mymovie.util.LiveDataUtil
import com.example.mymovie.util.PagedListUtil
import com.example.mymovie.core.utils.FakeData
import com.example.mymovie.core.vo.Resource
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.any
import org.mockito.Mockito.mock

class FilmRepositoryTest {
//
//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    private val remote = mock(RemoteDataSource::class.java)
//    private val local = mock(LocalDataSource::class.java)
//    private val filmRepository = FakeFilmRepository(remote, local)
//
//    private val tvShowResponse = FakeData.generateRemoteDummyTVShow()
//    private val movieResponse = FakeData.generatesRemoteDummyMovie()
//
//    private val tvShowSelected = FakeData.generateFakeTVShows()[0]
//    private val movieSelected = FakeData.generateFakeMovies()[0]
//
//    @Test
//    fun getAllMovie() {
//        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
//        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
//        filmRepository.getAllMovie()
//
//        val movieEntity = Resource.success(PagedListUtil.mockPagedList(FakeData.generateFakeMovies()))
//        verify(local).getAllMovies()
//        assertNotNull(movieEntity.data)
//        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())
//
//    }
//
//    @Test
//    fun getAllTVShow() {
//        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
//        `when`(local.getAllTVShow()).thenReturn(dataSourceFactory)
//        filmRepository.getAllTVShow()
//
//        val tvShowEntity = Resource.success(FakeData.generateFakeTVShows())
//        verify(local).getAllTVShow()
//        assertNotNull(tvShowEntity)
//        assertEquals(tvShowResponse.size.toLong(), tvShowEntity.data?.size?.toLong())
//
//    }
//
//    @Test
//    fun getSelectedMovie() {
//        val dummyMovie = MutableLiveData<Movie>()
//        dummyMovie.value = movieSelected
//        `when`(local.getMovieByImbdID(movieSelected.imdbID)).thenReturn(dummyMovie)
//
//        val movieEntities = LiveDataUtil.getValue(filmRepository.getSelectedMovie(movieSelected.imdbID))
//        verify(local).getMovieByImbdID(movieSelected.imdbID)
//        assertNotNull(movieEntities)
//        assertNotNull(movieEntities.data?.Title)
//        assertEquals(movieEntities.data?.Title, movieResponse[0].Title)
//        assertEquals(movieEntities.data?.imdbID, movieResponse[0].imdbID)
//        assertEquals(movieEntities.data?.Year, movieResponse[0].Year)
//    }
//
//    @Test
//    fun getSelectedTVShow() {
//        val dummyTVShow = MutableLiveData<TvShow>()
//        dummyTVShow.value = tvShowSelected
//        `when`(local.getTVShowByImbdID(tvShowSelected.imdbID)).thenReturn(dummyTVShow)
//
//        val tvShowEntities = LiveDataUtil.getValue(filmRepository.getSelectedTVShow(tvShowSelected.imdbID))
//        verify(local).getTVShowByImbdID(tvShowSelected.imdbID)
//        assertNotNull(tvShowEntities)
//        assertNotNull(tvShowEntities.data?.Title)
//        assertEquals(tvShowEntities.data?.Title, tvShowResponse[0].Title)
//        assertEquals(tvShowEntities.data?.imdbID, tvShowResponse[0].imdbID)
//        assertEquals(tvShowEntities.data?.Year, tvShowResponse[0].Year)
//    }
//
//    @Test
//    fun getBookmarkedMovie() {
//        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
//        `when`(local.getBookmarkedMovie()).thenReturn(dataSourceFactory)
//        filmRepository.getBookmarkedMovie()
//
//        val movieEntities = Resource.success(PagedListUtil.mockPagedList(FakeData.generateFakeMovies()))
//        verify(local).getBookmarkedMovie()
//        assertNotNull(movieEntities)
//        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
//    }
//
//    @Test
//    fun getBookmarkedTVShow(){
//        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
//        `when`(local.getBookmarkedTVShow()).thenReturn(dataSourceFactory)
//        filmRepository.getBookmarkedTVShow()
//
//        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(FakeData.generateFakeTVShows()))
//        verify(local).getBookmarkedTVShow()
//        assertNotNull(tvShowEntities)
//        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
//    }
}