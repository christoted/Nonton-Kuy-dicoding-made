package com.example.mymovie.presentation.ui.tvshow.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovie.core.domain.model.MovieNotEntity
import com.example.mymovie.core.domain.model.TVShowNotEntity
import com.example.mymovie.databinding.ItemCarouselBinding
import com.example.mymovie.databinding.ItemCarouselTvshowBinding

class ViewPager2TVShowAdapter(

) : RecyclerView.Adapter<ViewPager2TVShowAdapter.ViewPagerViewHolder>() {
    var banners = ArrayList<TVShowNotEntity>()

    fun setBanner(newBannerDatas: List<TVShowNotEntity>){
        banners.clear()
        banners.addAll(newBannerDatas)
        notifyDataSetChanged()
    }

    fun getBannerData(): List<TVShowNotEntity>{

        return banners
    }

    inner class ViewPagerViewHolder(private val binding: ItemCarouselTvshowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowNotEntity: TVShowNotEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(tvShowNotEntity.Poster)
                    .into(singleItemCarouselIvTvShow)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val carouselItem =
            ItemCarouselTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

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