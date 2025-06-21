package com.range.animeizle.animes.dto.request

import com.range.animeizle.animes.domain.entity.Anime
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

data class SeasonRequest (
    val seasonSize: Int,
    val seasonNumber: Int,
    val animeId: Long
)