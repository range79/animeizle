package com.range.animeizle.animes.dto.response

import com.range.animeizle.animes.domain.enums.AnimeStatus

data class AnimeResponse (

    var id: Long?,
    var title: String,
    var description: String,
    var animeStatus: AnimeStatus
)