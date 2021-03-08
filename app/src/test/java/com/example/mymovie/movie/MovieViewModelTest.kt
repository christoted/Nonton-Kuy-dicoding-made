package com.example.mymovie.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.mymovie.core.data.FilmRepository
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.ui.movie.MovieViewModel
import com.example.mymovie.core.utils.FakeData
import com.example.mymovie.core.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var filmRepository: FilmRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<Movie>>>

    @Mock
    private lateinit var pagedList: PagedList<Movie>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(filmRepository)
    }

    @Test
    fun getMovie() {
        val fakeMovie = Resource.success(pagedList)
        `when`(fakeMovie.data?.size).thenReturn(5)
        val movies = MutableLiveData<Resource<PagedList<Movie>>>()
        movies.value = fakeMovie

        `when`(filmRepository.getAllMovie()).thenReturn(movies)
        val movieEntities = viewModel.getMovie().value?.data
        verify(filmRepository).getAllMovie()

        assertNotNull(movieEntities)
        assertEquals(5, movieEntities?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(fakeMovie)
    }

}