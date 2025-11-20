package com.range.rangeWatch.anime.dto.response

import java.util.UUID

data class AnimeResponse(
    val id: UUID,
    val title: String,
    val description: String,
    val imageUrl: String,
)
