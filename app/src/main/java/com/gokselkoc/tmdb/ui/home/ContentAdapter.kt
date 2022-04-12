package com.gokselkoc.tmdb.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.tmdb.databinding.ContentItemViewBinding
import com.gokselkoc.tmdb.models.movie.MovieResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class ContentAdapter(
    var list: ArrayList<MovieResponse>,
    private val viewModel: MovieViewModel,
) :
    RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContentItemViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, viewModel)
    }

    fun addToAdapter(newList: ArrayList<MovieResponse>) {
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    inner class ViewHolder(
        private val binding: ContentItemViewBinding,
        private val dogCeoViewModel: MovieViewModel,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MovieResponse) {
            binding.item = item
            binding.viewModel = dogCeoViewModel
            binding.executePendingBindings()
        }

    }
}