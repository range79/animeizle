package com.range.animeizle.animes.api

import com.range.animeizle.animes.domain.enums.EpisodeStatus
import com.range.animeizle.animes.dto.request.EpisodeRequest
import com.range.animeizle.animes.dto.response.EpisodeResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/episodes")
interface EpisodeApi {
    @GetMapping("/{id}")
    fun findAllSeasonEpisodes(@PathVariable id: Long): List<EpisodeResponse>
    @PostMapping("/{id}/status")
    fun setEpisodeStatus(@PathVariable id: Long,@RequestParam(name="status", defaultValue = "false") status: EpisodeStatus): EpisodeResponse
    @PatchMapping("/{id}")
    fun updateEpisode(@PathVariable id: Long, @RequestBody episodeRequest: EpisodeRequest): EpisodeResponse

    @DeleteMapping("/{id}/details")
    fun deleteEpisode(
        @PathVariable id: Long,
        @RequestParam(defaultValue = "false")  details: Boolean
    ): ResponseEntity<EpisodeResponse?>

    @GetMapping("/all")
    fun findAll(): List<EpisodeResponse>

    @PostMapping("/add/{id}")
    fun addEpisode(@RequestBody episodeRequest: EpisodeRequest, @PathVariable id: Long): EpisodeResponse
}