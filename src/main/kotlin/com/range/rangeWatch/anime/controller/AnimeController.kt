package com.range.rangeWatch.anime.controller

import com.range.rangeWatch.anime.api.AnimeApi
import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.dto.AnimeUpdateRequest
import com.range.rangeWatch.anime.service.AnimeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@RestController
class AnimeController(
    private val animeService: AnimeService
) : AnimeApi {
    override fun getAll(pageable: Pageable): Page<Anime> {
        return animeService.getAll(pageable)
    }

    override fun getById(id: UUID): Anime {
        return animeService.getById(id)
    }

    override fun search(
        title: String,
        pageable: Pageable
    ): Page<Anime> {
        return animeService.searchByTitle(title, pageable)
    }

    override fun createAnime(
        anime: Anime,
        image: MultipartFile?
    ): Anime {
       return animeService.create(anime, image)
    }

    override fun updateAnime(
        id: UUID,
        anime: AnimeUpdateRequest,
        image: MultipartFile?
    ): Anime {
return animeService.update(id,anime,image)
    }

    override fun deleteAnime(id: UUID) {
        return animeService.delete(id)
    }
}