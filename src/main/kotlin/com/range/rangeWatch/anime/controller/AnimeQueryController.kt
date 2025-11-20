package com.range.rangeWatch.anime.controller

import com.range.rangeWatch.anime.api.AnimeQueryApi
import com.range.rangeWatch.anime.dto.response.AnimeResponse
import com.range.rangeWatch.anime.mapper.AnimeMapper
import com.range.rangeWatch.anime.service.AnimeQueryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class AnimeQueryController(
    private val animeQueryService: AnimeQueryService,
    private val animeMapper: AnimeMapper,
    ) : AnimeQueryApi {
    override fun getAll(pageable: Pageable): Page<AnimeResponse> {
        return animeQueryService.getAll(pageable)
            .map { animeMapper.toAnimeResponse(it) }
    }

    override fun getById(id: UUID): AnimeResponse {
        return animeMapper.toAnimeResponse(animeQueryService.getById(id))
    }

    override fun search(
        title: String,
        pageable: Pageable
    ): Page<AnimeResponse> {
        return animeQueryService.searchByTitle(title, pageable)
            .map { animeMapper.toAnimeResponse(it) }
    }


}