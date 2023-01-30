package com.tossdesu.filmography.presentation

import com.tossdesu.filmography.domain.entity.FilmBriefData

sealed class FilmSelectionsState()

object Error : FilmSelectionsState()
object Progress : FilmSelectionsState()
class ResponseFilmsData(
    val popular: List<FilmBriefData>,
    val awaited: List<FilmBriefData>,
    val premiere: List<FilmBriefData>
) : FilmSelectionsState()
