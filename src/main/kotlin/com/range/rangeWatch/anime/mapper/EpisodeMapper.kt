package com.range.rangeWatch.anime.mapper

import com.range.rangeWatch.anime.domain.entity.Episode
import com.range.rangeWatch.anime.dto.request.EpisodeRequest
import org.springframework.stereotype.Component

@Component
class EpisodeMapper {
    fun toEpisode(episodeRequest: EpisodeRequest): Episode {
        return Episode(
            title = episodeRequest.title,
            description = episodeRequest.description,
            episodeStatus = episodeRequest.episodeStatus,
            releaseDate = episodeRequest.releaseDate,
        )
    }
}