package com.range.animeizle.animes.mapper

import com.range.animeizle.animes.domain.entity.Episode
import com.range.animeizle.animes.dto.request.EpisodeRequest
import com.range.animeizle.animes.dto.response.EpisodeResponse
import org.springframework.stereotype.Component

@Component
class EpisodeMapper {
    fun episodeToEpisodeResponse(episode: Episode): EpisodeResponse {
        return EpisodeResponse(
            episode.id,
            episode.episodeNumber,
            episode.episodeStatus
        )
    }
    fun updateEpisode(episode: Episode,episodeRequest: EpisodeRequest){
        episode.apply {
            episodeNumber=episodeRequest.episodeNumber
            title=episodeRequest.title
            description=episodeRequest.description
            link=episodeRequest.link
            episodeStatus=episodeRequest.episodeStatus
        }
    }





}