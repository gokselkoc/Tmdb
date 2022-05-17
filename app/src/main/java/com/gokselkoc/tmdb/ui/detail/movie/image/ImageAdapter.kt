package com.gokselkoc.tmdb.ui.detail.movie.image

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.databinding.ImageItemBinding
import com.gokselkoc.tmdb.domain.models.moviedetail.image.ImageUIModel

class ImageAdapter(
    var list: ArrayList<ImageUIModel>,
    var isFullScreen: Boolean = false,
    private var onImageClicked: ((image: ImageUIModel, position: Int) -> Unit)? = null,
) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {


    fun addToAdapter(newList: ArrayList<ImageUIModel>) {
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ImageItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(list[position], isFullScreen, onImageClicked)
    }

    override fun getItemCount(): Int = list.size


    inner class ViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            data: ImageUIModel,
            isFullScreen: Boolean,
            onImageClicked: ((image: ImageUIModel, position: Int) -> Unit)?,
        ) {

            binding.item = data

            if (!isFullScreen) {
                val height =
                    binding.imageItemCardView.context.resources.getDimensionPixelOffset(R.dimen.height_150)
                val width = (height * data.aspectRatio).toInt()
                binding.imageItemCardView.layoutParams = LinearLayout.LayoutParams(width, height)

                binding.imageItemCardView.setOnClickListener {
                    onImageClicked?.invoke(data, position)
                }
            }
            binding.executePendingBindings()
        }
    }
}