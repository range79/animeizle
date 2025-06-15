package com.range.animeizle.animes.dao.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Table(name = "episodes")
@Entity
data class Episodes(
    @Id
    var id: Long,
    var episodeNumber: Int,
    var title: String,
    @ManyToOne
    @JoinColumn(name = "season_id")
    var season: Seasons
)
