package com.range.rangeWatch.anime.dto.request

import com.range.rangeWatch.anime.domain.enums.EpisodeStatus
import java.time.LocalDate
import java.util.UUID

data class EpisodeRequest (
    val title: String,
    val description: String,
    val episodeNumber: Long,
    val seasonId: UUID,
    val releaseDate: LocalDate,
    val episodeStatus: EpisodeStatus,
)