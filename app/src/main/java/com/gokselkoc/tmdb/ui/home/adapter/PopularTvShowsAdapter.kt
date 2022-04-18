package com.gokselkoc.tmdb.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.tmdb.databinding.PopularTvShowsViewBinding
import com.gokselkoc.tmdb.models.tvshows.TvShowsResponse
import com.gokselkoc.tmdb.ui.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class PopularTvShowsAdapter(
    var list: ArrayList<TvShowsResponse>,
    private val viewModel: HomeViewModel,
) :
    RecyclerView.Adapter<PopularTvShowsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PopularTvShowsViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, viewModel)
    }

    fun addToAdapter(newList: ArrayList<TvShowsResponse>) {
        list.addAll(newList)
        Log.e("ListSize", list.size.toString())
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    inner class ViewHolder(
        private val binding: PopularTvShowsViewBinding,
        private val homeFragmentViewModel: HomeViewModel,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TvShowsResponse) {
            binding.item = item
            binding.viewModel = homeFragmentViewModel
            binding.executePendingBindings()
        }

    }
}