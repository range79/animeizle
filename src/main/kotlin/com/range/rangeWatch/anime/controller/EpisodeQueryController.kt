package com.range.rangeWatch.anime.controller

import com.range.rangeWatch.anime.api.EpisodeQueryApi
import com.range.rangeWatch.anime.domain.entity.Episode
import com.range.rangeWatch.anime.service.EpisodeQueryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class EpisodeQueryController(private val episodeQueryService: EpisodeQueryService) : EpisodeQueryApi {
    override fun getAllSeasonEpisodes(
        pageable: Pageable,
        seasonId: UUID
    ): Page<Episode> {
        return episodeQueryService.getAllSeasonEpisodes(pageable, seasonId)
    }

    override fun gelAllEpisode(pageable: Pageable): Page<Episode> {
        return episodeQueryService.gelAllEpisode(pageable)
    }

    override fun getEpisodeById(id: UUID): Episode {
        return episodeQueryService.getEpisodeById(id)
    }
}