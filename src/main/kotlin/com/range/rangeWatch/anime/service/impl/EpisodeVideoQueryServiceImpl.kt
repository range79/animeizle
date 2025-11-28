package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.domain.enums.DubbingLanguage
import com.range.rangeWatch.anime.domain.enums.VideoQuality
import com.range.rangeWatch.anime.dto.response.EpisodeVideoResponse
import com.range.rangeWatch.anime.service.EpisodeVideoQueryService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EpisodeVideoQueryServiceImpl : EpisodeVideoQueryService {
    override fun getEpisodeVideo(
        videoId: UUID,
        dubbingLanguage: DubbingLanguage,
        quality: VideoQuality
    ): EpisodeVideoResponse {
TODO()
    }
}