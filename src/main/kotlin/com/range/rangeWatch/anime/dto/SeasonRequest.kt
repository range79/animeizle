package com.range.rangeWatch.anime.dto

import jakarta.validation.constraints.NotBlank

data class SeasonRequest (
    @field:NotBlank
    var title: String,
    var description: String
)