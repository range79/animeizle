package com.range.rangeWatch.anime.api

import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.dto.request.AnimeCreateRequest
import com.range.rangeWatch.anime.dto.request.AnimeUpdateRequest
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RequestMapping("\${api.prefix}/anime")
interface AnimeApi {



    @PostMapping(consumes = ["multipart/form-data"])
    fun createAnime(
        @RequestPart("anime") anime: AnimeCreateRequest,
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
