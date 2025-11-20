package com.range.rangeWatch.anime.controller

import com.range.rangeWatch.anime.api.AnimeCommandApi
import com.range.rangeWatch.anime.dto.request.AnimeCreateRequest
import com.range.rangeWatch.anime.dto.request.AnimeUpdateRequest
import com.range.rangeWatch.anime.service.AnimeCommandService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@RestController
class AnimeCommandController(
    private val animeCommandService: AnimeCommandService
) : AnimeCommandApi {

    override fun createAnime(
        anime: AnimeCreateRequest,
        image: MultipartFile?
    ) {
       return animeCommandService.create(anime, image)
    }

    override fun updateAnime(
        id: UUID,
        anime: AnimeUpdateRequest,
        image: MultipartFile?
    ) {
return  animeCommandService.update(id,anime,image)
    }

    override fun deleteAnime(id: UUID) {
        return animeCommandService.delete(id)
    }
}