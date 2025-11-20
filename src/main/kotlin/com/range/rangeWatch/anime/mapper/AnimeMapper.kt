package com.range.rangeWatch.anime.mapper

import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.dto.request.AnimeCreateRequest
import com.range.rangeWatch.anime.dto.response.AnimeResponse
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class AnimeMapper
{

    fun toAnime(animeRequest: AnimeCreateRequest): Anime{
        return Anime(
            id= UUID.randomUUID(),
            title= animeRequest.title,
            description= animeRequest.description,
        )
    }
    fun toAnimeResponse(anime: Anime): AnimeResponse {
        return AnimeResponse(
            id = anime.id,
            title = anime.title,
            description = anime.description,
            imageUrl = anime.imageUrl,
        )

}
}