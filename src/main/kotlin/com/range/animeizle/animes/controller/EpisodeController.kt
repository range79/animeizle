package com.range.animeizle.animes.controller

import com.range.animeizle.animes.api.EpisodeApi
import com.range.animeizle.animes.domain.enums.EpisodeStatus
import com.range.animeizle.animes.dto.request.EpisodeRequest
import com.range.animeizle.animes.dto.response.EpisodeResponse
import com.range.animeizle.animes.service.EpisodeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class EpisodeController(
    private val service: EpisodeService
): EpisodeApi {
    override fun findAllSeasonEpisodes(id: Long):List<EpisodeResponse> {
        return service.findAllSeasonEpisodes(id)
    }

    override fun setEpisodeStatus(
        id: Long,
        status: EpisodeStatus
    ): EpisodeResponse {
        return service.setEpisodeStatus(id, status)
    }

    override fun deleteEpisode(
        id: Long,
        details: Boolean
    ): ResponseEntity<EpisodeResponse?> {
        val response = service.deleteEpisode(id, details)
        return if (response!=null){
            ResponseEntity.ok(response)
        }else {
            ResponseEntity.noContent().build()
        }}

    override fun updateEpisode(
        id: Long,
        episodeRequest: EpisodeRequest
    ): EpisodeResponse {
        return service.updateEpisode(id, episodeRequest)
    }

    override fun findAll(): List<EpisodeResponse> {
        return service.findAll()
    }

    override fun addEpisode(
        episodeRequest: EpisodeRequest,
        id: Long
    ): EpisodeResponse {
        return service.addEpisode(episodeRequest, id)
    }
}