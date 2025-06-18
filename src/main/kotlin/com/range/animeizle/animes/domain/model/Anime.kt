package com.range.animeizle.animes.domain.model

import com.range.animeizle.animes.domain.enums.AnimeStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Table(name = "anime")
@Entity
data class Anime(
    @Id
    var id: Long,
    var title: String,
    var description: String,
    @OneToMany(mappedBy = "anime",fetch = FetchType.LAZY)
    val seasons: List<Season>,
    @Enumerated(EnumType.STRING)
    var animeStatus: AnimeStatus
)

