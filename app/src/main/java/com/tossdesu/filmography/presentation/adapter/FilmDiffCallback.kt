package com.tossdesu.filmography.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.tossdesu.filmography.domain.entity.FilmBriefData

class FilmDiffCallback : DiffUtil.ItemCallback<FilmBriefData>() {

    override fun areItemsTheSame(oldItem: FilmBriefData, newItem: FilmBriefData): Boolean {
        return oldItem.kinopoiskId == newItem.kinopoiskId
    }

    override fun areContentsTheSame(oldItem: FilmBriefData, newItem: FilmBriefData): Boolean {
        return oldItem == newItem
    }
}