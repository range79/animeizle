package com.range.rangeWatch.anime.controller

import com.range.rangeWatch.anime.api.AnimeApi
import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.dto.request.AnimeCreateRequest
import com.range.rangeWatch.anime.dto.request.AnimeUpdateRequest
import com.range.rangeWatch.anime.service.AnimeService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@RestController
class AnimeController(
    private val animeService: AnimeService
) : AnimeApi {

    override fun createAnime(
        anime: AnimeCreateRequest,
        image: MultipartFile?
    ) {
       return animeService.create(anime, image)
    }

    override fun updateAnime(
        id: UUID,
        anime: AnimeUpdateRequest,
        image: MultipartFile?
    ) {
return  animeService.update(id,anime,image)
    }

    override fun deleteAnime(id: UUID) {
        return animeService.delete(id)
    }
}