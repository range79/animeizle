package com.range.animeizle.animes.service

import com.range.animeizle.animes.domain.model.Anime

interface AnimeService {
    fun addAnime(anime: Anime): Long
    fun removeAnime(id: Long)
    fun updateAnime(id: Long, anime: Anime): Anime
    fun findAll(): List<Anime>

}
