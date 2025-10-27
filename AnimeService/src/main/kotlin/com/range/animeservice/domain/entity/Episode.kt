package com.range.animeservice.domain.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "episodes")
data class Episode(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    val episodeNumber: Int = 0,
    val description: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    var season: Season? = null
)
