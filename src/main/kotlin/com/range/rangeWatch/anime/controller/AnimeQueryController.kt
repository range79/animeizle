package com.range.rangeWatch.anime.controller

import com.range.rangeWatch.anime.api.AnimeQueryApi
import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.service.AnimeQueryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class AnimeQueryController(private val animeQueryService: AnimeQueryService) : AnimeQueryApi {
    override fun getAll(pageable: Pageable): Page<Anime> {
        return animeQueryService.getAll(pageable)
    }

    override fun getById(id: UUID): Anime {
        return animeQueryService.getById(id)
    }

    override fun search(
        title: String,
        pageable: Pageable
    ): Page<Anime> {
        return animeQueryService.searchByTitle(title, pageable)
    }


}