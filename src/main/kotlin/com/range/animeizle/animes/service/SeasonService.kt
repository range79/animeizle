package com.range.animeizle.animes.service

import com.range.animeizle.animes.domain.model.Season
import com.range.animeizle.animes.dto.response.SeasonResponse

interface SeasonService {
    fun findAllAnimeSeasons(animeid:Long): List<Season>
    fun findSeason(seasonNumber:Int): SeasonResponse
    fun removeSeason(id: Long)
}