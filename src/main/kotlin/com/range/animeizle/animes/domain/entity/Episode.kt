package com.range.animeizle.animes.domain.entity

import com.range.animeizle.animes.domain.enums.EpisodeStatus
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "episodes")
data class Episode(
    @Id
    val id: Long?,

    var episodeNumber: Int,
    var title: String,
    var description: String,
    var link: String,
    var episodeStatus: EpisodeStatus,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    var season: Season? = null
)

