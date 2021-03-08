package com.example.mymovie.presentation.ui.tvshow

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymovie.MyApplication
import com.example.mymovie.R
import com.example.mymovie.databinding.FragmentTvShowBinding
import com.example.mymovie.presentation.ui.detail.DetailActivity
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.presentation.ui.detail.DetailCollapseActivity
import com.example.mymovie.core.vo.Status
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvShowFragment : Fragment(), TVShowListener {

    private val viewModel: TvShowViewModel by viewModels ()


    private lateinit var binding: FragmentTvShowBinding
    private lateinit var tvShowAdapter: TVShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            binding.progressBar.visibility = View.VISIBLE


            tvShowAdapter = TVShowAdapter(this)
            viewModel.getTVShow().observe(viewLifecycleOwner, Observer { tvShows ->
                Log.d("TESTOY", "MESS: ${tvShows.message}")
                Log.d("TESTOY", "DATA: ${tvShows.data}")
                Log.d("TESTOY", "STAT: ${tvShows.status}")
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.SUCCESS -> {

                            Log.d("TVSHOW2", "onViewCreated: ${tvShows.data}")

                            binding.progressBar.visibility = View.GONE
                            binding.recyclerViewTVShow.visibility = View.VISIBLE
                            tvShows.data?.let {
                                tvShowAdapter.setTVShows(it)
                            }

                            Toast.makeText(requireActivity(), "Success", Toast.LENGTH_SHORT)
                                .show()
                        }

                        Status.LOADING -> {
                            binding.progressBar.visibility = View.VISIBLE
                            Toast.makeText(requireActivity(), "Loading", Toast.LENGTH_SHORT)
                                .show()
                        }

                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(requireActivity(), "Error Occurred", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }


                }
            })

            //   listTVShow = viewModel.getTVShow() as ArrayList<TvShow>

            with(binding.recyclerViewTVShow) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = tvShowAdapter

            }
        }


    }

    override fun onTVShowClickedListener(Position: Int) {
        val tvShow = tvShowAdapter.getTVShows()[Position]
        val intent = Intent(context, DetailCollapseActivity::class.java)


        val options = ActivityOptionsCompat.makeScaleUpAnimation(
            requireView(), 10, 10, 10, 10
        )

        intent.putExtra(DetailActivity.RECEIVE_INTENT_TVSHOWS, tvShow)
        startActivity(intent, options.toBundle())
    }
}