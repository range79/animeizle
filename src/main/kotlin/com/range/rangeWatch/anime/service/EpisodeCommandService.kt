package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.dto.request.EpisodeRequest
import java.util.UUID

interface EpisodeCommandService {
    fun createEpisode(episodeRequest: EpisodeRequest)
    fun deleteEpisode(episodeId: UUID)
    fun updateEpisode(episodeId: UUID,episodeRequest: EpisodeRequest)
}