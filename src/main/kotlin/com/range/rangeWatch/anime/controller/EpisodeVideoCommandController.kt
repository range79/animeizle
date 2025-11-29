package com.range.rangeWatch.anime.controller

import com.range.rangeWatch.anime.api.EpisodeVideoCommandApi
import com.range.rangeWatch.anime.dto.request.EpisodeVideoRequest
import com.range.rangeWatch.anime.service.EpisodeVideoCommandService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@RestController
class EpisodeVideoCommandController(private val episodeVideoCommandService: EpisodeVideoCommandService): EpisodeVideoCommandApi {
    override fun uploadVideo(
        file: MultipartFile,
        episodeVideoRequest: EpisodeVideoRequest
    ) {
        return episodeVideoCommandService.uploadVideo(episodeVideoRequest, file)
    }
    //todo need think about removing
    override fun deleteVideo(videoId: UUID) {
        return episodeVideoCommandService.removeVideo(videoId)
    }
}