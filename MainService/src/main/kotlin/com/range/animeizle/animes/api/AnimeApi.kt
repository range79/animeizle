package com.range.animeizle.animes.api

import com.range.animeizle.animes.domain.enums.AnimeStatus
import com.range.animeizle.animes.dto.request.AnimeRequest
import com.range.animeizle.animes.dto.response.AnimeResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("\${api.prefix}/anime")
interface AnimeApi {

    @PostMapping("/add")
    fun addAnime(@RequestBody @Valid animeRequest: AnimeRequest): AnimeResponse
    @DeleteMapping("/{id}/details")
    fun removeAnime(@PathVariable id: Long, @RequestParam(defaultValue = "false") details: Boolean): ResponseEntity<AnimeResponse?>
    @PatchMapping("/{id}")
    fun updateAnime(
        @PathVariable id: Long,
        @RequestBody animeRequest: AnimeRequest
    ): AnimeResponse
    @GetMapping("/all")
    fun findAll(): List<AnimeResponse>
    @PatchMapping("/{id}/status")
    fun setAnimeStatus(@PathVariable id: Long,  @RequestParam status: AnimeStatus ): AnimeResponse
}