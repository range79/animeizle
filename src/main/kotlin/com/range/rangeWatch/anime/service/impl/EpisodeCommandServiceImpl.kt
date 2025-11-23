package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.domain.repository.EpisodeRepository
import com.range.rangeWatch.anime.dto.request.EpisodeRequest
import com.range.rangeWatch.anime.mapper.EpisodeMapper
import com.range.rangeWatch.anime.service.EpisodeCommandService
import com.range.rangeWatch.anime.service.EpisodeQueryService
import com.range.rangeWatch.anime.service.SeasonQueryService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EpisodeCommandServiceImpl(
    private val episodeRepository: EpisodeRepository,
    private val seasonQueryService: SeasonQueryService,
    private val episodeMapper: EpisodeMapper,
    private val episodeQueryService: EpisodeQueryService
) : EpisodeCommandService {
    override fun createEpisode(episodeRequest: EpisodeRequest) {
        val episode = episodeMapper.toEpisode(episodeRequest)
        val season = seasonQueryService.getSeason(episodeRequest.seasonId)
        episode.season = season
        episodeRepository.save(episode)
    }

    override fun deleteEpisode(episodeId: UUID) {
        val episode = episodeQueryService.getEpisodeById(episodeId)
        episodeRepository.delete(episode)
    }

    override fun updateEpisode(
        episodeId: UUID,
        episodeRequest: EpisodeRequest
    ) {
        val episode =episodeQueryService.getEpisodeById(episodeId).apply {
            title = episodeRequest.title
            description = episodeRequest.description
            episodeStatus = episodeRequest.episodeStatus
        }

        if (episode.season?.id != episodeRequest.seasonId) {
            val newSeason = seasonQueryService.getSeason(episodeRequest.seasonId)
            episode.season = newSeason
        }
        episodeRepository.save(episode)

    }

}