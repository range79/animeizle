package com.range.animeizle.animes.api

import com.range.animeizle.animes.domain.entity.Season
import com.range.animeizle.animes.dto.request.SeasonRequest
import com.range.animeizle.animes.dto.response.SeasonResponse
import jakarta.servlet.ServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1")
interface SeasonApi {
    @GetMapping("/season/{animeId}")
    fun findAllAnimeSeasons(@PathVariable animeId:Long, servletResponse: ServletResponse): ResponseEntity<List<SeasonResponse>>
    @GetMapping("/season/{id}")
    fun findSeason(@PathVariable id: Long): ResponseEntity<Season>
    @DeleteMapping("/season/{id}/details")
    fun removeSeason(@PathVariable id: Long,@RequestParam details : Boolean): ResponseEntity<SeasonResponse?>
    @PostMapping("/season")
    fun add(@RequestBody seasonRequest: SeasonRequest): ResponseEntity<SeasonResponse>
}