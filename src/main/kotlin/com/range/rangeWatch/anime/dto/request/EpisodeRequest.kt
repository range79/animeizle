package com.range.rangeWatch.anime.dto.request

import com.range.rangeWatch.anime.domain.entity.Season
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

data class EpisodeRequest(

    var title: String = "",
    var description: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    var season: Season? = null,
)
