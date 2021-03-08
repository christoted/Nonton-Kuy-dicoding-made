package com.example.mymovie.fav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymovie.fav.databinding.ActivityFavModuleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavModuleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavModuleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavModuleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPagerAdapter = ViewPagerAdapter(this, supportFragmentManager)
        binding.viewPagerActivityFavourite.adapter = viewPagerAdapter
        binding.tabLayoutActivity.setupWithViewPager(binding.viewPagerActivityFavourite)
    }
}