package com.tossdesu.filmography.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.tossdesu.filmography.databinding.ItemFilmBinding
import com.tossdesu.filmography.domain.entity.FilmBriefData
import javax.inject.Inject

class FilmsAdapter @Inject constructor() : ListAdapter<FilmBriefData, FilmHolder>(FilmDiffCallback()) {

    var setOnClickListener: ((Int) -> Unit)? = null
    var setOnLongClickListener: ((FilmBriefData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context))
        return FilmHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
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
}