package com.range.animeizle.animes.dto.response

import com.range.animeizle.animes.domain.enums.EpisodeStatus

data class EpisodeResponse(
    var id: Long?,

    var episodeNumber: Int,
    var episodeStatus: EpisodeStatus,
)