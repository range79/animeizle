package com.range.animeizle.animes.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Table(name = "episodes")
@Entity
data class Episode(
    @Id
    var id: Long,
    var episodeNumber: Int,
    var title: String,
    var description: String,
    var link: String,
    @ManyToOne
    @JoinColumn(name = "season_id")
    var season: Season
)
