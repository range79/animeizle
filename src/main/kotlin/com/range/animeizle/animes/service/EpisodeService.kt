package com.range.animeizle.animes.service

import com.range.animeizle.animes.domain.enums.EpisodeStatus
import com.range.animeizle.animes.dto.request.EpisodeRequest
import com.range.animeizle.animes.dto.response.EpisodeResponse

interface EpisodeService {

    fun findAllSeasonEpisodes(id: Long): List<EpisodeResponse>
    fun setEpisodeStatus(id: Long, status: EpisodeStatus): EpisodeResponse
    fun updateEpisode(seasonId: Long, episodeRequest: EpisodeRequest): EpisodeResponse
    fun deleteEpisode(id: Long,description: Boolean): EpisodeResponse?
    fun findAll(): List<EpisodeResponse>
    fun addEpisode(episodeRequest: EpisodeRequest, seasonId: Long): EpisodeResponse

}