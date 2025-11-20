package com.range.rangeWatch.anime.dto.request

import jakarta.validation.constraints.NotBlank

data class SeasonRequest (
    @field:NotBlank
    var title: String,
    var description: String
)