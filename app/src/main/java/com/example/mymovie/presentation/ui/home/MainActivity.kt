package com.example.mymovie.presentation.ui.home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mymovie.R
import com.example.mymovie.core.vo.Status
import com.example.mymovie.databinding.ActivityMainBinding
import com.example.mymovie.presentation.ui.favourite.FavouriteFragment
import com.example.mymovie.presentation.ui.movie.MovieFragment
import com.example.mymovie.presentation.ui.movie.MovieViewModel
import com.example.mymovie.presentation.ui.search.SearchFragment
import com.example.mymovie.presentation.ui.setting.FavouriteActivity
import com.example.mymovie.presentation.ui.tvshow.TvShowFragment
import com.example.mymovie.presentation.ui.tvshow.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel: MovieViewModel by viewModels ()


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //     supportActionBar?.elevation = 0f
        val movieFragment = MovieFragment()
        setCurrentFragment(movieFragment)

        callTVShowFragment()


        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.movie -> {
                    val movieFragment = MovieFragment()
                    setCurrentFragment(movieFragment)
                }

                R.id.tvShow -> {
                    val tvShowFragment = TvShowFragment()
                    setCurrentFragment(tvShowFragment)
                }

                R.id.search -> {
                    val searchFragment = SearchFragment()
                    setCurrentFragment(searchFragment)
                }
            }
            true
        }

    }

    private fun callTVShowFragment() {
        viewModel.getMovie().observe(this, Observer { tvShows ->
            if (tvShows != null) {
                when (tvShows.status) {
                    Status.SUCCESS -> {
                        Log.d("KELUAR GAK PANTEK", "onViewCreated: ${tvShows.data}")

                    }

                    Status.LOADING -> {


                    }

                    Status.ERROR -> {

                    }
                }


            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            addToBackStack(null)
            commit()
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        when (item.itemId) {
            R.id.setting -> {
                startActivity(Intent(this, FavouriteActivity::class.java))
//                val uri = Uri.parse("mymovie://fav")
//                startActivity(Intent(Intent.ACTION_VIEW, uri))

            }
        }
        return true
    }
}