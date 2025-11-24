package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.domain.entity.Episode
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface EpisodeQueryService {
    fun getAllSeasonEpisodes(pageable: Pageable, seasonId: UUID): Page<Episode>
    fun gelAllEpisode(pageable: Pageable): Page<Episode>
    fun getEpisodeById(id: UUID): Episode

}

