package com.range.animeizle.animes.dto.request

import com.range.animeizle.animes.domain.enums.AnimeStatus

data class AnimeRequest (
    val title: String,
    val description: String,
    var animeStatus: AnimeStatus,
)