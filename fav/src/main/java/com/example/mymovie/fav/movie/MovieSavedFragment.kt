package com.example.mymovie.fav.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.fav.databinding.FragmentMovieSavedBinding
import com.example.mymovie.presentation.ui.detail.DetailCollapseActivity
import com.example.mymovie.presentation.ui.favourite.moviefav.MovieFavFragment
import com.example.mymovie.presentation.ui.movie.MovieAdapter
import com.example.mymovie.presentation.ui.movie.MovieItemListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieSavedFragment : Fragment(), MovieItemListener {

    private val viewModel: MovieFavViewModel by viewModels()

    private lateinit var binding: FragmentMovieSavedBinding

    private lateinit var movieAdapter: MovieAdapter

    companion object {
        val TAG = MovieFavFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieSavedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieAdapter = MovieAdapter(this)

        if ( activity != null) {
            //    val viewModelFactory = ViewModelFactory.getInstance(requireActivity())
            //      viewModel = ViewModelProvider(this, viewModelFactory)[MovieFavViewModel::class.java]
            viewModel.getMovieSaved().observe(viewLifecycleOwner, Observer {
                //  listSavedMovie.addAll(it)
                movieAdapter.setData(it)

            })
        }

        binding.recyclerViewMovieModuleFav.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = movieAdapter
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.getMovieSaved().observe(viewLifecycleOwner, Observer {
            movieAdapter.setData(it)
        })
    }

    override fun onMovieItemClicked(Position: Int) {
        val intent = Intent(context, DetailCollapseActivity::class.java)
        val movie = movieAdapter.listMovie[Position]
        intent.putExtra(DetailCollapseActivity.RECEIVE_INTENT_MOVIE, movie)
        startActivity(intent)
    }


}