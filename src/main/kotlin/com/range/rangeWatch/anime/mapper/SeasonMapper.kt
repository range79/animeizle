package com.range.rangeWatch.anime.mapper

import com.range.rangeWatch.anime.domain.entity.Season
import com.range.rangeWatch.anime.dto.request.SeasonRequest
import com.range.rangeWatch.anime.dto.response.SeasonResponse
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SeasonMapper {
    fun toSeason(season: SeasonRequest): Season {
        return Season(
            id = UUID.randomUUID(),
            title = season.title,
            description = season.description
        )
    }

    fun toSeasonResponse(season: Season): SeasonResponse{
        return SeasonResponse(
            id = season.id,
            title = season.title,
            description = season.description,
            imageUrl = season.imageUrl,
            )
    }



}