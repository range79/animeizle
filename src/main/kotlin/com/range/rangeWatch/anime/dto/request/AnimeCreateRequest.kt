package com.range.rangeWatch.anime.dto.request

import jakarta.validation.constraints.NotEmpty

data class AnimeCreateRequest (
    @field:NotEmpty
    var title: String,
    @field:NotEmpty
    var description: String,
)