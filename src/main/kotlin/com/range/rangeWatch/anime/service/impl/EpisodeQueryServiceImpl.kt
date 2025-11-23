package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.domain.entity.Episode
import com.range.rangeWatch.anime.domain.repository.EpisodeRepository
import com.range.rangeWatch.anime.exception.EpisodeNotFoundException
import com.range.rangeWatch.anime.service.EpisodeQueryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EpisodeQueryServiceImpl (
    private val episodeRepository: EpisodeRepository,
): EpisodeQueryService
{
    override fun getAllSeasonEpisodes(
        pageable: Pageable,
        seasonId: UUID
    ): Page<Episode> {
        return episodeRepository.findAllBySeasonId(seasonId, pageable)
    }

    override fun gelAllEpisode(pageable: Pageable): Page<Episode> {
        return episodeRepository.findAll(pageable)
    }

    override fun getEpisodeById(id: UUID): Episode {
        return episodeRepository.findById(id).orElseThrow { EpisodeNotFoundException("Episode Not Found") }
    }

}