package com.range.animeizle.animes.api

import com.range.animeizle.animes.domain.entity.Season
import com.range.animeizle.animes.domain.enums.AnimeStatus
import com.range.animeizle.animes.dto.response.SeasonResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1")
interface SeasonApi {
    @GetMapping("/season/{animeId}")
    fun findAllAnimeSeasons(@PathVariable animeId:Long): List<SeasonResponse>
    @GetMapping("/season/{id}")
    fun findSeason(@PathVariable id: Long): Season
    @DeleteMapping("/season/{id}/details")
    fun removeSeason(@PathVariable id: Long,@RequestParam status: AnimeStatus): SeasonResponse?
}