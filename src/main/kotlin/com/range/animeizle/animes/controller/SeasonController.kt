package com.range.animeizle.animes.controller

import com.range.animeizle.animes.api.SeasonApi
import com.range.animeizle.animes.domain.entity.Season
import com.range.animeizle.animes.dto.request.SeasonRequest
import com.range.animeizle.animes.dto.response.SeasonResponse
import com.range.animeizle.animes.service.SeasonService
import jakarta.servlet.ServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class SeasonController(val seasonService: SeasonService): SeasonApi {
    override fun findAllAnimeSeasons(animeId: Long, servletResponse: ServletResponse): ResponseEntity<List<SeasonResponse>> {
        return  ResponseEntity.ok(seasonService.findAllAnimeSeasons(animeId))
    }

    override fun findSeason(id: Long): ResponseEntity<Season> {
        return ResponseEntity.ok(seasonService.findSeason(id))
    }

    override fun removeSeason(
        id: Long,
        details: Boolean
    ): ResponseEntity<SeasonResponse?> {
        val season = seasonService.removeSeason(id, details)
        if(season != null) {
            return ResponseEntity.ok(season)
        }
        return ResponseEntity.noContent().build()
    }

    override fun add(seasonRequest: SeasonRequest): ResponseEntity<SeasonResponse> {
        return ResponseEntity.ok(seasonService.add(seasonRequest))
    }

    override fun updateSeason(
        id: Long,
        seasonRequest: SeasonRequest
    ): ResponseEntity<SeasonResponse> {
        return ResponseEntity.ok(seasonService.update(id, seasonRequest))
    }


}

