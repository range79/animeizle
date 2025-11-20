package com.range.rangeWatch.anime.mapper

import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.dto.request.AnimeCreateRequest
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


}