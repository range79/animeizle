package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.domain.entity.Season
import com.range.rangeWatch.anime.dto.SeasonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID


interface SeasonService {
    fun animeSeasons(animeId: Long, pageable: Pageable): Page<Season>
    fun getSeason(id: UUID): Season
    fun create(seasonRequest: SeasonRequest): Season
    fun deleteSeason(id: UUID)
    fun updateSeason(id: UUID, seasonRequest: SeasonRequest)
}