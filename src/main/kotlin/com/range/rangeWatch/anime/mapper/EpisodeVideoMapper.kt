package com.range.rangeWatch.anime.mapper

import com.range.rangeWatch.anime.domain.entity.EpisodeVideo
import com.range.rangeWatch.anime.dto.response.EpisodeVideoResponse
import org.springframework.stereotype.Component

@Component
class EpisodeVideoMapper {

    fun toEpisodeVideoResponse(episodeVideo: EpisodeVideo): EpisodeVideoResponse {
        return EpisodeVideoResponse(
            videolink = episodeVideo.url
        )
    }
}