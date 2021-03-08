package com.example.mymovie.home


import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.mymovie.R
import com.example.mymovie.ui.home.MainActivity
import com.example.mymovie.core.utils.EspressoIdlingResource
import com.example.mymovie.core.utils.FakeData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.logging.Handler
import kotlin.coroutines.CoroutineContext


class MainActivityTest {
    private val dummyMovies = FakeData.generateFakeMovies()
    private val dummyTVShow = FakeData.generateFakeTVShows()

    @Before
    fun setup(){
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }


    @Test
    fun loadMovie() {

        onView(withId(R.id.recyclerViewMovie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.recyclerViewMovie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.recyclerViewMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(9,
            ViewActions.click()
        ))

        onView(withId(R.id.movieTitleDetail))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.movieTitleDetail))
            .check(ViewAssertions.matches(withText(dummyMovies[9].Title)))

        onView(withId(R.id.movieReleaseDateDetail))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.movieReleaseDateDetail))
            .check(ViewAssertions.matches(withText(dummyMovies[9].Year)))

        onView(withId(R.id.movieAuthorDetail))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.movieAuthorDetail))
            .check(ViewAssertions.matches(withText(dummyMovies[9].imdbID)))

        onView(withId(R.id.fab)).perform(ViewActions.click())
    }

    @Test
    fun loadFavouriteFirst(){
        onView(withId(R.id.favourite)).perform(ViewActions.click())
        onView(withId(R.id.recyclerViewFav))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


     //   onView(withId(R.id.recyclerViewFav)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTVShow.size))

     //   onView(withId(R.id.recyclerViewFav)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
    }

    @Test
    fun loadFavouriteSecond(){
        onView(withId(R.id.favourite)).perform(ViewActions.click())
        onView(withId(R.id.recyclerViewFav))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        onView(withId(R.id.recyclerViewFav)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTVShow.size))

        onView(withId(R.id.recyclerViewFav)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
    }


    @Test
    fun loadTVShows() {

        onView(withId(R.id.tvShow)).perform(ViewActions.click())
        onView(withId(R.id.recyclerViewTVShow))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.recyclerViewTVShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTVShow.size))
    }


}