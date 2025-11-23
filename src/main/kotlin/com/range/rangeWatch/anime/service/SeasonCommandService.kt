package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.dto.request.SeasonRequest
import java.util.*


interface SeasonCommandService {
    fun create(seasonRequest: SeasonRequest)
    fun deleteSeason(id: UUID)
    fun updateSeason(id: UUID, seasonRequest: SeasonRequest)
}