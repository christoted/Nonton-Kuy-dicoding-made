package com.example.mymovie.presentation.ui.favourite.tvshowfav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.databinding.FragmentTVShowFavBinding
import com.example.mymovie.presentation.ui.detail.DetailCollapseActivity
import com.example.mymovie.presentation.ui.setting.tvshowfav.TVShowFavViewModel
import com.example.mymovie.presentation.ui.tvshow.TVShowAdapter
import com.example.mymovie.presentation.ui.tvshow.TVShowListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TVShowFavFragment : Fragment(), TVShowListener {

    private val viewModel: TVShowFavViewModel by viewModels()


    private lateinit var binding: FragmentTVShowFavBinding

    private lateinit var tvShowAdapter: TVShowAdapter

    private lateinit var listSavedTVShow: ArrayList<TvShow>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTVShowFavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listSavedTVShow = ArrayList()

        tvShowAdapter = TVShowAdapter(this@TVShowFavFragment)

        if ( activity != null) {
          //  val factory = ViewModelFactory.getInstance(requireActivity())
      //      viewModel = ViewModelProvider(this, factory)[TVShowFavViewModel::class.java]

            viewModel.getSavedTVShow().observe(viewLifecycleOwner, Observer {
              //  listSavedTVShow.addAll(it)
                tvShowAdapter.setTVShows(it)
            })
        }

        binding.recylerViewFavTVShow.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getSavedTVShow().observe(viewLifecycleOwner, Observer {
            tvShowAdapter.setTVShows(it)
        })
    }

    override fun onTVShowClickedListener(Position: Int) {
        val intent = Intent(context, DetailCollapseActivity::class.java)
        val tvShow = tvShowAdapter.getTVShows()[Position]
        intent.putExtra(DetailCollapseActivity.RECEIVE_INTENT_TVSHOWS, tvShow)
        startActivity(intent)
    }

}