package com.example.mymovie.presentation.ui.setting.moviefav

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
import com.example.mymovie.databinding.FragmentMovieFavouriteBinding
import com.example.mymovie.presentation.ui.detail.DetailCollapseActivity
import com.example.mymovie.presentation.ui.favourite.moviefav.MovieFavFragment
import com.example.mymovie.presentation.ui.movie.MovieAdapter
import com.example.mymovie.presentation.ui.movie.MovieItemListener
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class MovieFavouriteFragment : Fragment(), MovieItemListener {

    private val viewModel: MovieFavViewModel by viewModels ()
    private lateinit var listSavedMovie: ArrayList<Movie>

    private lateinit var binding: FragmentMovieFavouriteBinding

    private lateinit var movieAdapter: MovieAdapter

    companion object {
        val TAG = MovieFavFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieFavouriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listSavedMovie = ArrayList()

        movieAdapter = MovieAdapter(this)

        if ( activity != null) {
            //    val viewModelFactory = ViewModelFactory.getInstance(requireActivity())
            //      viewModel = ViewModelProvider(this, viewModelFactory)[MovieFavViewModel::class.java]
            Log.d(MovieFavFragment.TAG, "onViewCreated: ${listSavedMovie.size}")
            viewModel.getMovieSaved().observe(viewLifecycleOwner, Observer {
                //  listSavedMovie.addAll(it)
                if ( it.isEmpty()) {
                    binding.layoutEmpty.root.visibility = View.VISIBLE
                } else {
                    binding.layoutEmpty.root.visibility = View.GONE
                    movieAdapter.setData(it)
                }
            })
        }

        binding.recyclerViewFav.apply {
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