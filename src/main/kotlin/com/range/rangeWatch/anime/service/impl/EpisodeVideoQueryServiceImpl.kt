package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.domain.entity.EpisodeVideo
import com.range.rangeWatch.anime.domain.enums.DubbingLanguage
import com.range.rangeWatch.anime.domain.enums.VideoQuality
import com.range.rangeWatch.anime.dto.response.EpisodeVideoResponse
import com.range.rangeWatch.anime.exception.EpisodeVideoNotFoundException
import com.range.rangeWatch.anime.domain.repository.EpisodeVideoRepository
import com.range.rangeWatch.anime.service.EpisodeVideoQueryService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EpisodeVideoQueryServiceImpl(private val episodeVideoRepository: EpisodeVideoRepository) : EpisodeVideoQueryService
{
    override fun getEpisodeVideo(
        videoId: UUID,
        dubbingLanguage: DubbingLanguage,
        quality: VideoQuality
        ): EpisodeVideo {
            return episodeVideoRepository.findByEpisode_IdAndDubbingLanguageAndQuality(videoId,dubbingLanguage,quality)
                ?:throw EpisodeVideoNotFoundException("Episode Video not found")
    }
}