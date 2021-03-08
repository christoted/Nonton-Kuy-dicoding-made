package com.example.mymovie.presentation.ui.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymovie.R
import com.example.mymovie.databinding.ActivityFavouriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavouriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityFavouriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewPagerAdapter = ViewPagerAdapter(this, supportFragmentManager)
        binding.viewPagerActivityFavourite.adapter = viewPagerAdapter
        binding.tabLayoutActivity.setupWithViewPager(binding.viewPagerActivityFavourite)
    }
}