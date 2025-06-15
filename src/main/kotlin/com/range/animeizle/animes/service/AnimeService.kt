package com.range.animeizle.animes.service

import com.range.animeizle.animes.domain.model.Anime

interface AnimeService {
    fun addAnime(Anime: Anime): Long
    fun removeAnime(id: Long)
    fun updateAnime(id: Long, anime: Anime): Long
    fun findAll(): List<Anime>




}
