package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.domain.entity.Season
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface SeasonQueryService {
    fun animeSeasons(animeId: UUID, pageable: Pageable): Page<Season>
    fun getSeason(id: UUID): Season
}