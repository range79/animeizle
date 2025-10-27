package com.range.animeservice.domain.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "seasons")
data class Season(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    var name: String? = null,
    var description: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anime_id")
    var anime: Anime? = null,

    @OneToMany(mappedBy = "season", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var episodes: MutableList<Episode> = mutableListOf()
)
