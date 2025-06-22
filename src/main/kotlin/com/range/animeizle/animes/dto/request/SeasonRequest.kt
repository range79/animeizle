package com.range.animeizle.animes.dto.request



data class SeasonRequest (
    val seasonSize: Int,
    val seasonNumber: Int,
    val animeId: Long
)