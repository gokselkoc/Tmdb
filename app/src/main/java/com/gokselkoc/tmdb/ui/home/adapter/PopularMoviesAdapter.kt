package com.gokselkoc.tmdb.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.tmdb.databinding.ContentItemViewBinding
import com.gokselkoc.tmdb.models.movie.MovieResponse
import com.gokselkoc.tmdb.ui.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class PopularMoviesAdapter(
    var list: ArrayList<MovieResponse>,
    private val viewModel: HomeViewModel,
) :
    RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContentItemViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, viewModel)
    }

    fun addToAdapter(newList: ArrayList<MovieResponse>) {

        viewModel.allPopularMovieList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    inner class ViewHolder(
        private val binding: ContentItemViewBinding,
        private val homeFragmentViewModel: HomeViewModel,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MovieResponse) {
            binding.item = item
            binding.viewModel = homeFragmentViewModel
            binding.executePendingBindings()
        }
    }
}