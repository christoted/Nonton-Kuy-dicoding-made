package com.example.mymovie.presentation.ui.movie

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymovie.MyApplication
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.databinding.FragmentMovieBinding
import com.example.mymovie.presentation.ui.detail.DetailActivity
import com.example.mymovie.presentation.ui.detail.DetailCollapseActivity
import com.example.mymovie.presentation.ui.tvshow.TVShowAdapter
import com.example.mymovie.presentation.ui.tvshow.TvShowViewModel
import com.example.mymovie.core.vo.Status
import com.example.mymovie.presentation.ui.movie.banner.ViewPager2Adapter
import com.example.mymovie.presentation.ui.tvshow.TVShowListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.math.log

@AndroidEntryPoint
class MovieFragment : Fragment(), MovieItemListener {


    private val viewModel: MovieViewModel by viewModels ()
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewPagerAdapter : ViewPager2Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        val TAG = "movie"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (activity != null) {

            binding.progressBar.visibility = View.VISIBLE
            movieAdapter = MovieAdapter(this)
            viewPagerAdapter = ViewPager2Adapter()

            viewModel.getMovie().observe(viewLifecycleOwner, Observer { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.SUCCESS -> {

                            binding.progressBar.visibility = View.GONE
                            binding.recyclerViewMovie.visibility = View.VISIBLE
                            movies.data?.let {
                                Log.d(TAG, "onViewCreated: $it")
                                movieAdapter.setData(it)

                                viewPagerAdapter.setBanner(it)

                                binding.indicator.setViewPager(binding.viewPagerBanner)
                            }


                        }
                        Status.LOADING -> {
                            binding.progressBar.visibility = View.VISIBLE

                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(requireActivity(), "Error Occurred", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }

            })

            binding.viewPagerBanner.adapter = viewPagerAdapter
            binding.indicator.setViewPager(binding.viewPagerBanner)


            binding.indicator.setViewPager(binding.viewPagerBanner)

            with(binding.recyclerViewMovie) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = movieAdapter
            }


        }
    }

    override fun onMovieItemClicked(Position: Int) {
        val intent = Intent(context, DetailCollapseActivity::class.java)
        val movie = movieAdapter.listMovie[Position]

        val options = ActivityOptionsCompat.makeScaleUpAnimation(
            requireView(), 0, 0, 0, 0
        )

        intent.putExtra(DetailActivity.RECEIVE_INTENT_MOVIE, movie)
        startActivity(intent, options.toBundle())

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        activity?.setActionBar(null)

    }


}