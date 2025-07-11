package com.range.animeizle.animes.mapper

import com.range.animeizle.animes.domain.entity.Anime
import com.range.animeizle.animes.dto.request.AnimeRequest
import com.range.animeizle.animes.dto.response.AnimeResponse
import org.springframework.stereotype.Component

@Component
class AnimeMapper {
    fun animeRequestToAnime(request: AnimeRequest): Anime {
        return  Anime(
            id = null,
            title = request.title,
            description = request.description,
            animeStatus = request.animeStatus,
            seasons = mutableListOf()
        )}

    fun animeToAnimeResponse(anime: Anime): AnimeResponse {
        return AnimeResponse(
            id = anime.id,
            title = anime.title,
            description = anime.description,
            animeStatus = anime.animeStatus
        )
    }
    fun updateFromRequest(anime:Anime, animeRequest:AnimeRequest){
         anime.apply{
            title = animeRequest.title
            description = animeRequest.description
            animeStatus = animeRequest.animeStatus
    }
    }

}




