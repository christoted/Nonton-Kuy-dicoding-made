package com.example.mymovie.presentation.ui.setting.tvshowfav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymovie.core.data.local.entity.TvShow
import com.example.mymovie.databinding.FragmentTVShowFavouriteBinding
import com.example.mymovie.presentation.ui.detail.DetailCollapseActivity
import com.example.mymovie.presentation.ui.tvshow.TVShowAdapter
import com.example.mymovie.presentation.ui.tvshow.TVShowListener
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class TVShowFavouriteFragment : Fragment(), TVShowListener {

    private val viewModel: TVShowFavViewModel by viewModels()


    private lateinit var binding: FragmentTVShowFavouriteBinding

    private lateinit var tvShowAdapter: TVShowAdapter

    private lateinit var listSavedTVShow: ArrayList<TvShow>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTVShowFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listSavedTVShow = ArrayList()

        tvShowAdapter = TVShowAdapter(this)

        if ( activity != null) {
            //  val factory = ViewModelFactory.getInstance(requireActivity())
            //      viewModel = ViewModelProvider(this, factory)[TVShowFavViewModel::class.java]

            viewModel.getSavedTVShow().observe(viewLifecycleOwner, Observer {
                //  listSavedTVShow.addAll(it)
                if ( it.isEmpty()) {
                    binding.layoutEmpty.root.visibility = View.VISIBLE
                } else {
                    tvShowAdapter.setTVShows(it)
                    binding.layoutEmpty.root.visibility = View.GONE
                }

            })
        }

        binding.recyclerViewTVShowFav.apply {
            adapter = tvShowAdapter
            layoutManager = GridLayoutManager(requireActivity(),2)
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