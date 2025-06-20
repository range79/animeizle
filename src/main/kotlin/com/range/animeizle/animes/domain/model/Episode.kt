package com.range.animeizle.animes.domain.model

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
    val id: Long,

    val episodeNumber: Int,
    val title: String,
    val description: String,
    val link: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    var season: Season? = null
)

