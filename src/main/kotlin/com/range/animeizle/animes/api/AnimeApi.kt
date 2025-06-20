package com.range.animeizle.animes.api

import com.range.animeizle.animes.dto.request.AnimeRequest
import com.range.animeizle.animes.dto.response.AnimeResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/v1/anime")
interface AnimeApi {
    @PostMapping("/")
    fun AddAnime(animeRequest: AnimeRequest): AnimeResponse
    @DeleteMapping("/{id}")
    fun RemoveAnime(@PathVariable id: Long, @RequestParam(defaultValue = "false") returnDetails: Boolean): ResponseEntity<AnimeResponse?>
    @PatchMapping("/{id}")
    fun UpdateAnime(@PathVariable id: Long,@RequestBody animeRequest: AnimeRequest): ResponseEntity<AnimeResponse>
    @GetMapping("/all")
    fun findAll(): ResponseEntity<List<AnimeResponse>>
}