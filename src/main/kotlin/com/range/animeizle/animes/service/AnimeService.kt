package com.range.animeizle.animes.service

import com.range.animeizle.animes.domain.entity.Anime
import com.range.animeizle.animes.domain.enums.AnimeStatus
import com.range.animeizle.animes.dto.request.AnimeRequest
import com.range.animeizle.animes.dto.response.AnimeResponse

interface AnimeService {
    fun addAnime(animeRequest: AnimeRequest): AnimeResponse
    fun removeAnime(id: Long,returnDetails: Boolean): AnimeResponse?
    fun updateAnime(id: Long, animeRequest: AnimeRequest): AnimeResponse
    fun findAll(): List<AnimeResponse>
    fun setAnimeStatus(animeId: Long, status: AnimeStatus): AnimeResponse
    fun findAnimeWithId(animeId: Long): Anime

}
