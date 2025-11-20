package com.range.rangeWatch.anime.controller

import com.range.rangeWatch.anime.api.SeasonQueryApi
import com.range.rangeWatch.anime.dto.response.SeasonResponse
import com.range.rangeWatch.anime.mapper.SeasonMapper
import com.range.rangeWatch.anime.service.SeasonQueryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class SeasonQueryController(
    private val seasonQueryService: SeasonQueryService,
    private val seasonMapper: SeasonMapper
): SeasonQueryApi
{
    override fun animeSeasons(
        animeId: UUID,
        pageable: Pageable
    ): Page<SeasonResponse> {
        return seasonQueryService.animeSeasons(animeId, pageable).map { seasonMapper.toSeasonResponse(it) }
    }

    override fun getSeason(seasonId: UUID): SeasonResponse {
    return seasonMapper.toSeasonResponse(seasonQueryService.getSeason(seasonId))
    }
}