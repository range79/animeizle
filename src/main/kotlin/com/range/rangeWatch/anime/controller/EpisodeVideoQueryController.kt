package com.range.rangeWatch.anime.controller

import com.range.rangeWatch.anime.api.EpisodeVideoQueryApi
import com.range.rangeWatch.anime.domain.enums.DubbingLanguage
import com.range.rangeWatch.anime.domain.enums.VideoQuality
import com.range.rangeWatch.anime.dto.request.EpisodeVideoRequest
import com.range.rangeWatch.anime.dto.response.EpisodeVideoResponse
import com.range.rangeWatch.anime.mapper.EpisodeVideoMapper
import com.range.rangeWatch.anime.service.EpisodeVideoQueryService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@RestController
class EpisodeVideoQueryController (
    private val episodeVideoQueryService: EpisodeVideoQueryService,
    private val episodeVideoMapper: EpisodeVideoMapper
): EpisodeVideoQueryApi{


    override fun getEpisodeVideo(
        episodeId: UUID,
        dubbingLanguage: DubbingLanguage,
        quality: VideoQuality
    ): EpisodeVideoResponse {
        return episodeVideoMapper.toEpisodeVideoResponse(episodeVideoQueryService.getEpisodeVideo(episodeId, dubbingLanguage, quality))
    }


}