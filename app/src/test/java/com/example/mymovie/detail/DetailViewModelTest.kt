package com.example.mymovie.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.mymovie.core.data.FilmRepository
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.core.utils.FakeData
import com.example.mymovie.core.vo.Resource
import com.nhaarman.mockitokotlin2.isA
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.invocation.InvocationOnMock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

//    private lateinit var viewModel: DetailViewModel
//
//    private val dummyMovie = FakeData.generateFakeMovies()[0]
//    private val dummyTVShow = FakeData.generateFakeTVShows()[0]
//
//    private val dummyMovieImbdID = dummyMovie.imdbID
//    private val dummyTVShowImbdID = dummyTVShow.imdbID
//
//
//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    @Mock
//    private lateinit var filmRepository: FilmRepository
//
//    @Mock
//    private lateinit var movieObserver: Observer<Resource<Movie>>
//
//    @Mock
//    private lateinit var tvShowObserver: Observer<Resource<TvShow>>
//
//    @Before
//    fun setup() {
//        viewModel = DetailViewModel(filmRepository)
//        viewModel.setSelectedMovie(dummyMovieImbdID)
//        viewModel.setSelectedTVShow(dummyTVShowImbdID)
//
//        viewModel.setBookMarkedMovie(dummyMovie)
//        viewModel.setBookMarkedTVShow(dummyTVShow)
//    }
//
//    @Test
//     fun whenAddBookmarkedVerified() {
//        val detailViewModel = mock(DetailViewModel::class.java)
//        doNothing().`when`(detailViewModel).setBookMarkedMovie(dummyMovie)
//        detailViewModel.setBookMarkedMovie(dummyMovie)
//        verify(detailViewModel, times(1)).setBookMarkedMovie(dummyMovie)
//    }
//
//    @Test(expected = Exception::class)
//    fun givenNull_AddThrows() {
//        val detailViewModel = mock(DetailViewModel::class.java)
//        doThrow().`when`(detailViewModel).setBookMarkedMovie(dummyMovie)
//        detailViewModel.setBookMarkedMovie(dummyMovie)
//    }
//
//    @Test
//    fun whenAddCalledAnswered() {
//        val detailViewModel = mock(DetailViewModel::class.java)
//        doAnswer { invocation: InvocationOnMock ->
//            val arg0 = invocation.getArgument<Any>(0)
//            assertEquals(dummyMovie, arg0)
//            null
//        }.`when`(detailViewModel).setBookMarkedMovie(dummyMovie)
//        detailViewModel.setBookMarkedMovie(dummyMovie)
//    }
//
//    @Test
//    fun whenAddBookmarkedTVShowVerified() {
//        val detailViewModel = mock(DetailViewModel::class.java)
//        doNothing().`when`(detailViewModel).setBookMarkedTVShow(dummyTVShow)
//        detailViewModel.setBookMarkedTVShow(dummyTVShow)
//        verify(detailViewModel, times(1)).setBookMarkedTVShow(dummyTVShow)
//    }
//
//    @Test(expected = Exception::class)
//    fun givenNull_AddThrows_TVShow() {
//        val detailViewModel = mock(DetailViewModel::class.java)
//        doThrow().`when`(detailViewModel).setBookMarkedTVShow(dummyTVShow)
//        detailViewModel.setBookMarkedTVShow(dummyTVShow)
//    }
//
//    @Test
//    fun whenAddCalledAnsweredTVShow() {
//        val detailViewModel = mock(DetailViewModel::class.java)
//        doAnswer { invocation: InvocationOnMock ->
//            val arg0 = invocation.getArgument<Any>(0)
//            assertEquals(dummyTVShow, arg0)
//            null
//        }.`when`(detailViewModel).setBookMarkedTVShow(dummyTVShow)
//        detailViewModel.setBookMarkedTVShow(dummyTVShow)
//    }
//
//
//    @Test
//    fun getMovieSelected() {
//
//        val movie = MutableLiveData<Resource<Movie>>()
//        movie.value = Resource.success(dummyMovie)
//
//        `when`(filmRepository.getSelectedMovie(dummyMovieImbdID)).thenReturn(movie)
//
//        viewModel.setSelectedMovie(dummyMovieImbdID)
//        val movieEntity = viewModel.getMovieSelected().value?.data
//        verify(filmRepository).getSelectedMovie(dummyMovieImbdID)
//
//        assertNotNull(movieEntity)
//        assertEquals(movieEntity?.imdbID, dummyMovie.imdbID)
//        assertEquals(movieEntity?.Year, dummyMovie.Year)
//        assertEquals(movieEntity?.Poster, dummyMovie.Poster)
//        assertEquals(movieEntity?.Title, dummyMovie.Title)
//        assertEquals(movieEntity?.Type, dummyMovie.Type)
//
//        viewModel.getMovieSelected().observeForever(movieObserver)
//        verify(movieObserver).onChanged(movie.value)
//    }
//
//    @Test
//    fun getTVShowSelected() {
//
//        val tvShow = MutableLiveData<Resource<TvShow>>()
//        tvShow.value = Resource.success(dummyTVShow)
//
//        `when`(filmRepository.getSelectedTVShow(dummyTVShowImbdID)).thenReturn(tvShow)
//
//        viewModel.setSelectedTVShow(dummyTVShowImbdID)
//        val tvShowEntity = viewModel.getTVShowSelected().value?.data
//        verify(filmRepository).getSelectedTVShow(dummyTVShowImbdID)
//
//        assertNotNull(tvShowEntity)
//        assertEquals(tvShowEntity?.imdbID, dummyTVShow.imdbID)
//        assertEquals(tvShowEntity?.Year, dummyTVShow.Year)
//        assertEquals(tvShowEntity?.Poster, dummyTVShow.Poster)
//        assertEquals(tvShowEntity?.Title, dummyTVShow.Title)
//        assertEquals(tvShowEntity?.Type, dummyTVShow.Type)
//
//        viewModel.getTVShowSelected().observeForever(tvShowObserver)
//        verify(tvShowObserver).onChanged(tvShow.value)
//    }
}