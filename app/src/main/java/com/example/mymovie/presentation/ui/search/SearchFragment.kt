package com.example.mymovie.presentation.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovie.core.data.remote.StatusResponse
import com.example.mymovie.core.vo.Status
import com.example.mymovie.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class SearchFragment : Fragment(), MovieSearchItemListener{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private var _binding: FragmentSearchBinding ?= null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()

    private lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchAdapter = SearchAdapter(this@SearchFragment)

        viewModel.getMovieSearchWithoutSuspend("Avenger", "5").observe(viewLifecycleOwner, Observer {
            when(it.status) {
                StatusResponse.SUCCESS -> {
                    val movieServiceResponse = it.body
                    val movieListSearch = movieServiceResponse?.Search

                    if ( movieListSearch != null) {
                        searchAdapter.setMoviesSearch(movieListSearch)
                    }
                }

                StatusResponse.EMPTY -> {
                    Log.d("SearchFragmentWithout", "onViewCreated: ${it.body}")
                    Toast.makeText(activity, "${it.body}}", Toast.LENGTH_SHORT).show()
                }

                StatusResponse.LOADING -> {
                    Log.d("SearchFragmentWithout", "onViewCreated: ${it.body}")
                    Toast.makeText(activity, "${it.body}}", Toast.LENGTH_SHORT).show()
                }

                StatusResponse.ERROR -> {
                    Log.d("SearchFragmentWithout", "onViewCreated: ${it.body}")
                    Toast.makeText(activity, "${it.body}}", Toast.LENGTH_SHORT).show()
                }
            }
        })

        with(binding.recyclerViewSearch) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = searchAdapter
        }

        viewModel.getMovieSearch()
        viewModel.movieSearch.observe(viewLifecycleOwner, Observer {
         //   Log.d("SearchFragment", "onViewCreated: ${it.body}")
                if ( it != null ) {
                    when(it.status) {
                        StatusResponse.SUCCESS -> {
                            Log.d("SearchFragment", "onViewCreated: ${it.body}")
                        }

                        StatusResponse.ERROR -> {

                        }

                        StatusResponse.LOADING -> {

                        }

                        StatusResponse.EMPTY -> {

                        }
                    }
                }


        })



    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClicked(position: Int) {
        TODO("Not yet implemented")
    }
}