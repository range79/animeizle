package com.range.animeizle.animes.controller

import com.range.animeizle.animes.api.AnimeApi
import com.range.animeizle.animes.domain.enums.AnimeStatus
import com.range.animeizle.animes.dto.request.AnimeRequest
import com.range.animeizle.animes.dto.response.AnimeResponse
import com.range.animeizle.animes.service.AnimeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AnimeController(
    val animeService: AnimeService
) : AnimeApi {

    override fun addAnime(animeRequest: AnimeRequest): AnimeResponse  {
        return animeService.addAnime(animeRequest)
    }

    override fun removeAnime(
        id: Long,
        details: Boolean
    ): ResponseEntity<AnimeResponse?> {

        val removedAnime = animeService.removeAnime(id, details)
        return if (details && removedAnime != null) {
            ResponseEntity.ok(removedAnime)
        } else {
            ResponseEntity.noContent().build()
        }
    }

    override fun updateAnime(
        id: Long,
        animeRequest: AnimeRequest
    ): AnimeResponse {
        return animeService.updateAnime(id, animeRequest)
    }

    override fun findAll(): List<AnimeResponse> {
        return animeService.findAll()
    }

    override fun setAnimeStatus(
        id: Long,
        status: AnimeStatus
    ): AnimeResponse {
        return animeService.setAnimeStatus(id,status)
    }
}