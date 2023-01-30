package com.tossdesu.filmography.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.tossdesu.filmography.databinding.ItemFilmBigBinding
import com.tossdesu.filmography.domain.entity.FilmBriefData
import javax.inject.Inject

class FilmsBigAdapter @Inject constructor() : ListAdapter<FilmBriefData, FilmBigHolder>(FilmDiffCallback()) {

    var setOnClickListener: ((Int) -> Unit)? = null
    var setOnLongClickListener: ((FilmBriefData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmBigHolder {
        val binding = ItemFilmBigBinding.inflate(LayoutInflater.from(parent.context))
        return FilmBigHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmBigHolder, position: Int) {
        val item = getItem(holder.adapterPosition)
        with(holder.binding) {
            tvTitle.text = item.nameRu
            if (item.posterUrl.isNotEmpty()) {
                Glide.with(root.context).load(item.posterUrl).into(ivPoster)
            }
            root.setOnClickListener {
                setOnClickListener?.invoke(item.kinopoiskId)
            }
            root.setOnLongClickListener {
                setOnLongClickListener?.invoke(item)
                true
            }
        }
    }

    override fun getItemCount(): Int = currentList.size
}