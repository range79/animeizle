package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.dto.request.EpisodeRequest
import java.util.UUID

interface EpisodeCommandService {
    fun create(episodeRequest: EpisodeRequest)
    fun update(id: UUID, episodeRequest: EpisodeRequest)
    fun delete(id: UUID)
}