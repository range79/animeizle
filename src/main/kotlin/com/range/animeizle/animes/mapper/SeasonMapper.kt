package com.range.animeizle.animes.mapper

import com.range.animeizle.animes.domain.entity.Season
import com.range.animeizle.animes.dto.request.SeasonRequest
import com.range.animeizle.animes.dto.response.SeasonResponse
import org.springframework.stereotype.Component

@Component
class SeasonMapper {

    fun seasonToSeasonResponse(season: Season): SeasonResponse {
        return SeasonResponse(
            id = season.id,
            seasonNumber = season.seasonNumber,
            seasonSize = season.seasonSize,
        )
    }






}