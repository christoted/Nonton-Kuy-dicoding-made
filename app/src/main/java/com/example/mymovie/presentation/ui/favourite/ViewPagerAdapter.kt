package com.example.mymovie.presentation.ui.favourite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mymovie.R
import com.example.mymovie.presentation.ui.favourite.moviefav.MovieFavFragment
import com.example.mymovie.presentation.ui.favourite.tvshowfav.TVShowFavFragment

class ViewPagerAdapter (private val context: Context, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movieFav, R.string.tvshowFav)
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when(position) {
            0 -> MovieFavFragment()
            1 -> TVShowFavFragment()
            else -> Fragment()
    }

    override fun getPageTitle(position: Int): CharSequence? = context.resources.getString(TAB_TITLES[position])

}