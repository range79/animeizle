package com.range.rangeWatch.anime.dto.request

import jakarta.validation.constraints.NotBlank
import software.amazon.awssdk.annotations.NotNull
import java.util.UUID

data class SeasonRequest (
    val animeId: UUID,
    @field:NotNull
    val seasonNumber: Int,
    @field:NotBlank
    var title: String,
    var description: String
)