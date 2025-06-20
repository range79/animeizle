package com.range.animeizle.animes.service

import com.range.animeizle.animes.domain.model.Anime
import com.range.animeizle.animes.dto.request.AnimeRequest
import com.range.animeizle.animes.dto.response.AnimeResponse

interface AnimeService {
    fun addAnime(animeRequest: AnimeRequest): AnimeResponse
    fun removeAnime(id: Long): AnimeResponse
    fun updateAnime(id: Long, animeRequest: AnimeRequest): AnimeResponse
    fun findAll(): List<AnimeResponse>

}
