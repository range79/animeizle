package com.range.animeizle.animes.api

import com.range.animeizle.animes.domain.enums.EpisodeStatus
import com.range.animeizle.animes.dto.request.EpisodeRequest
import com.range.animeizle.animes.dto.response.EpisodeResponse
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/episodes")
interface EpisodeApi {
    @GetMapping("/{id}")
    fun findAllSeasonEpisodes(@PathVariable id: Long): ResponseEntity<List<EpisodeResponse>>
    @PostMapping("/{id}/status")
    fun setEpisodeStatus(@PathVariable id: Long,@RequestParam(name="status", defaultValue = "false") status: EpisodeStatus): ResponseEntity<EpisodeResponse>
    @PatchMapping("/{id}")
    fun updateEpisode(@PathVariable id: Long, @RequestBody episodeRequest: EpisodeRequest): ResponseEntity<EpisodeResponse>

    @DeleteMapping("/{id}")
    fun deleteEpisode(
        @PathVariable id: Long,
        @RequestParam description: Boolean): ResponseEntity<EpisodeResponse?>

    @GetMapping("/all")
    fun findAll(): ResponseEntity<List<EpisodeResponse>>

    @PostMapping("/add/{id}")
    fun addEpisode(@RequestBody episodeRequest: EpisodeRequest, @PathVariable id: Long): ResponseEntity<EpisodeResponse>
}