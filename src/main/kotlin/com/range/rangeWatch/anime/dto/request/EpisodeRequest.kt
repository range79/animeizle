package com.range.rangeWatch.anime.dto.request

import com.range.rangeWatch.anime.domain.entity.Season
import com.range.rangeWatch.anime.domain.enums.EpisodeStatus
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.util.UUID

data class EpisodeRequest(
    @field:NotEmpty(message = "Episode Title can't be empty")
    var title: String,
    var description: String,
    @param:NotNull
    var seasonId: UUID,
    var releaseDate: LocalDate? = null,
    var episodeStatus: EpisodeStatus? = null,
)
