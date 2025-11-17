package com.range.rangeWatch.anime.api

import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.dto.AnimeUpdateRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RequestMapping("\${api.prefix}/anime")
interface AnimeApi {

    @GetMapping
    fun getAll(pageable: Pageable): Page<Anime>

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): Anime

    @GetMapping("/search")
    fun search(@RequestParam title: String, pageable: Pageable): Page<Anime>

    @PostMapping(consumes = ["multipart/form-data"])
    fun createAnime(
        @RequestPart("anime") anime: Anime,
        @RequestPart("image", required = false) image: MultipartFile?
    ): Anime

    @PutMapping("/{id}", consumes = ["multipart/form-data"])
    fun updateAnime(
        @PathVariable id: UUID,
        @RequestPart("anime") anime: AnimeUpdateRequest,
        @RequestPart("image", required = false) image: MultipartFile?
    ): Anime

    @DeleteMapping("/{id}")
    fun deleteAnime(@PathVariable id: UUID)
}
