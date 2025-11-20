package com.range.rangeWatch.anime.api

import com.range.rangeWatch.anime.domain.entity.Season
import com.range.rangeWatch.anime.dto.response.SeasonResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@RequestMapping("\${api.prefix}/season}")
interface SeasonQueryApi {

@GetMapping("/{animeId}")
    fun animeSeasons(@PathVariable animeId: UUID, pageable: Pageable): Page<SeasonResponse>
    @GetMapping("/{seasonId}")
    fun getSeason(@PathVariable seasonId: UUID): SeasonResponse


}