package com.example.mymovie.presentation.ui.movie.banner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovie.core.domain.model.Banner
import com.example.mymovie.core.domain.model.MovieNotEntity
import com.example.mymovie.databinding.ItemCarouselBinding

class ViewPager2Adapter(

) : RecyclerView.Adapter<ViewPager2Adapter.ViewPagerViewHolder>() {
    var banners = ArrayList<MovieNotEntity>()

    fun setBanner(newBannerDatas: List<MovieNotEntity>){
        banners.clear()
        banners.addAll(newBannerDatas)
        notifyDataSetChanged()
    }

    fun getBannerData(): List<MovieNotEntity>{

        return banners
    }

    inner class ViewPagerViewHolder(private val binding: ItemCarouselBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieNotEntity: MovieNotEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(movieNotEntity.Poster)
                    .into(singleItemCarouselIv)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val carouselItem =
            ItemCarouselBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewPagerViewHolder(carouselItem)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val banner = banners[position]

        holder.bind(banner)
    }

    override fun getItemCount(): Int {
        return banners.size
    }
}