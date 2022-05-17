package com.gokselkoc.tmdb.ui.detail.movie.trailer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.tmdb.databinding.TrailerItemBinding
import com.gokselkoc.tmdb.domain.models.moviedetail.trailer.TrailerUIModel
import com.gokselkoc.tmdb.ui.detail.movie.MovieDetailViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class TrailerAdapter(
    var list: ArrayList<TrailerUIModel>,
    var viewModel: MovieDetailViewModel,
) :
    RecyclerView.Adapter<TrailerAdapter.ViewHolder>() {


    fun addToAdapter(newList: ArrayList<TrailerUIModel>) {
        list.addAll(newList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TrailerItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(
        private val binding: TrailerItemBinding,
        private val viewModel: MovieDetailViewModel,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TrailerUIModel) {
            binding.item = item
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }
}