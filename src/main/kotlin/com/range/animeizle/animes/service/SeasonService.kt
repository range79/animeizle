package com.range.animeizle.animes.service

import com.range.animeizle.animes.domain.entity.Season
import com.range.animeizle.animes.dto.request.SeasonRequest
import com.range.animeizle.animes.dto.response.SeasonResponse

interface SeasonService {
    fun findAllAnimeSeasons(animeid:Long): List<SeasonResponse>
    fun findSeason(id: Long): Season
    fun removeSeason(id: Long,details: Boolean): SeasonResponse?
    fun add(seasonRequest: SeasonRequest): SeasonResponse
    fun update(id: Long,season: Season): SeasonResponse
}