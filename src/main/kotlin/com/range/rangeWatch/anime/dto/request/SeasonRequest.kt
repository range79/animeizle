package com.range.rangeWatch.anime.dto.request

import jakarta.validation.constraints.NotBlank
import java.util.UUID

data class SeasonRequest (
    val animeId: UUID,
    @field:NotBlank
    var title: String,
    var description: String
)