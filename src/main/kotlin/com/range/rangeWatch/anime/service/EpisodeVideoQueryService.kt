package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.domain.entity.EpisodeVideo
import com.range.rangeWatch.anime.domain.enums.DubbingLanguage
import com.range.rangeWatch.anime.domain.enums.VideoQuality
import com.range.rangeWatch.anime.dto.response.EpisodeVideoResponse
import java.util.UUID

interface EpisodeVideoQueryService {
    fun getEpisodeVideo(videoId: UUID,dubbingLanguage: DubbingLanguage,quality: VideoQuality): EpisodeVideo
}