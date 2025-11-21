package com.range.rangeWatch.anime.controller

import com.range.rangeWatch.anime.api.SeasonCommandApi
import com.range.rangeWatch.anime.dto.request.SeasonRequest
import com.range.rangeWatch.anime.service.SeasonCommandService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class SeasonCommandController(
    private val seasonCommandService: SeasonCommandService
): SeasonCommandApi {
    override fun create(seasonRequest: SeasonRequest) {
        return seasonCommandService.create(seasonRequest)
    }

    override fun deleteSeason(seasonId: UUID) {
        return seasonCommandService.deleteSeason(seasonId)
    }

    override fun updateSeason(
        seasonId: UUID,
        seasonRequest: SeasonRequest
    ) {
        return seasonCommandService.updateSeason(seasonId, seasonRequest)
    }
}