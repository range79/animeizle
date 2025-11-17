package com.range.rangeWatch.anime.domain.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "episode")
data class Episode(
    @Id
    var id: UUID = UUID.randomUUID(),

    var title: String = "",
    var description: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    var season: Season? = null,

    @OneToMany(mappedBy = "episode", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var videos: MutableList<EpisodeVideo> = mutableListOf()
)

