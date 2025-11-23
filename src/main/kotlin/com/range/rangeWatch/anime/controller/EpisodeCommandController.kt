package com.range.rangeWatch.anime.controller

import com.range.rangeWatch.anime.api.EpisodeCommandApi
import com.range.rangeWatch.anime.dto.request.EpisodeRequest
import com.range.rangeWatch.anime.service.EpisodeCommandService
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class EpisodeCommandController(private val episodeCommandService: EpisodeCommandService) : EpisodeCommandApi {
    override fun createEpisode(episodeRequest: EpisodeRequest) {
        return episodeCommandService.createEpisode(episodeRequest)
    }

    override fun deleteEpisode(episodeId: UUID) {
        return episodeCommandService.deleteEpisode(episodeId)
    }

    override fun updateEpisode(
        episodeId: UUID,
        episodeRequest: EpisodeRequest
    ) {
        return episodeCommandService.updateEpisode(episodeId, episodeRequest)
    }
}