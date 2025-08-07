package com.range.animeizle.animes.api

import com.range.animeizle.animes.domain.entity.Season
import com.range.animeizle.animes.dto.request.SeasonRequest
import com.range.animeizle.animes.dto.response.SeasonResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/seasons")
interface   SeasonApi {
    @GetMapping("/anime/{animeId}")
    fun findAllAnimeSeasons(@PathVariable animeId:Long ): List<SeasonResponse>
    @GetMapping("/{id}")
    fun findSeason(@PathVariable id: Long): Season
    @DeleteMapping("/{id}/details")
    fun removeSeason(
        @PathVariable id: Long,
        @RequestParam(defaultValue = "false") details : Boolean
    ): ResponseEntity<SeasonResponse?>
    @PostMapping("/add")
    fun add(@RequestBody seasonRequest: SeasonRequest): SeasonResponse
    @PatchMapping("/{id}")
    fun updateSeason(@PathVariable id: Long,  @RequestBody seasonRequest: SeasonRequest): SeasonResponse
}