package com.range.rangeWatch.anime.domain.entity

import com.range.rangeWatch.anime.domain.enums.EpisodeStatus
import jakarta.persistence.*
import java.time.LocalDate
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
    var episodeStatus: EpisodeStatus,
    var releaseDate: LocalDate? = null ,

    @OneToMany(mappedBy = "episode", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var videos: MutableList<EpisodeVideo> = mutableListOf()

)

