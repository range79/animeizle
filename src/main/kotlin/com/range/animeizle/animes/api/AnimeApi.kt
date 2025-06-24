package com.range.animeizle.animes.api

import com.range.animeizle.animes.domain.enums.AnimeStatus
import com.range.animeizle.animes.dto.request.AnimeRequest
import com.range.animeizle.animes.dto.response.AnimeResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/anime")
interface AnimeApi {

    @PostMapping("/app")
    fun addAnime(@RequestBody animeRequest: AnimeRequest): ResponseEntity<AnimeResponse>
    @DeleteMapping("/{id}/details")
    fun removeAnime(@PathVariable id: Long, @RequestParam(defaultValue = "false") details: Boolean): ResponseEntity<AnimeResponse?>
    @PatchMapping("/{id}")
    fun updateAnime(
        @PathVariable id: Long,
        @RequestBody animeRequest: AnimeRequest
    ): ResponseEntity<AnimeResponse>
    @GetMapping("/all")
    fun findAll(): ResponseEntity<List<AnimeResponse>>
    @PatchMapping("/{id}/status")
    fun setAnimeStatus(@PathVariable id: Long,  @RequestParam status: AnimeStatus ): ResponseEntity<AnimeResponse>
}