package com.example.mymovie.presentation.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymovie.databinding.FragmentTvShowBinding
import com.example.mymovie.presentation.ui.detail.DetailActivity
import com.example.mymovie.presentation.ui.detail.DetailCollapseActivity
import com.example.mymovie.core.vo.Status
import com.example.mymovie.presentation.ui.tvshow.banner.ViewPager2TVShowAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : Fragment(), TVShowListener {

    private val viewModel: TvShowViewModel by viewModels ()

    private var _binding: FragmentTvShowBinding ? = null

    private val binding get() = _binding!!

    private lateinit var tvShowAdapter: TVShowAdapter

    private lateinit var viewPager2Adapter: ViewPager2TVShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            binding.progressBar.visibility = View.VISIBLE

            tvShowAdapter = TVShowAdapter(this)
            viewPager2Adapter = ViewPager2TVShowAdapter()
            viewModel.getTVShow().observe(viewLifecycleOwner, Observer { tvShows ->
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.SUCCESS -> {

                            Log.d("TVSHOW2", "onViewCreated: ${tvShows.data}")

                            binding.progressBar.visibility = View.GONE
                            binding.recyclerViewTVShow.visibility = View.VISIBLE
                            tvShows.data?.let {
                                tvShowAdapter.setTVShows(it)
                                viewPager2Adapter.setBanner(it)

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

            //   listTVShow = viewModel.getTVShow() as ArrayList<TvShow>

            binding.viewPagerBanner.adapter = viewPager2Adapter
            binding.indicator.setViewPager(binding.viewPagerBanner)

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        activity?.setActionBar(null)
    }
}