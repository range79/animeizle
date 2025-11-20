package com.range.rangeWatch.anime.mapper

import com.range.rangeWatch.anime.domain.entity.Season
import com.range.rangeWatch.anime.dto.response.SeasonResponse
import org.springframework.stereotype.Component

@Component
class SeasonMapper {

    fun toSeasonResponse(season: Season): SeasonResponse{
        return SeasonResponse(
            id = season.id,
            title = season.title,
            description = season.description,
            imageUrl = season.imageUrl,
            )
    }



}