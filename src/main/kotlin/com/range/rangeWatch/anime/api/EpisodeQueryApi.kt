package com.range.rangeWatch.anime.api

import com.range.rangeWatch.anime.domain.entity.Episode
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RequestMapping("\${api.prefix}/seasons")
interface EpisodeQueryApi {

    @GetMapping("/{seasonId}/episodes")
    fun getAllSeasonEpisodes(
        @RequestParam pageable: Pageable,
        @PathVariable seasonId: UUID
    ): Page<Episode>

    @GetMapping("/all/episodes")
    fun gelAllEpisode(@RequestParam pageable: Pageable): Page<Episode>

    @GetMapping("/episodes/{id}")
    fun getEpisodeById(@PathVariable id: UUID): Episode
}