package com.gokselkoc.tmdb.ui.detail.movie.genre

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.tmdb.databinding.GenreItemBinding
import com.gokselkoc.tmdb.models.moviedetail.GenreResponse

import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class GenreAdapter(
    var list: ArrayList<GenreResponse>,
) :
    RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GenreItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    fun addToAdapter(newList: ArrayList<GenreResponse>) {
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    inner class ViewHolder(
        private val binding: GenreItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GenreResponse) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}