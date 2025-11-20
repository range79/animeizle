package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.domain.entity.Season
import com.range.rangeWatch.anime.dto.request.SeasonRequest
import java.util.*


interface SeasonService {
    fun create(seasonRequest: SeasonRequest): Season
    fun deleteSeason(id: UUID)
    fun updateSeason(id: UUID, seasonRequest: SeasonRequest)
}