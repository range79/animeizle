package com.range.animeizle.animes.dao.model

import com.range.animeizle.animes.enums.AnimeStatus
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Table(name = "anime")
@Entity
data class Animes(
    @Id
    var id: Long,
    var title: String,
    var description: String,
    @OneToMany(mappedBy = "anime",fetch = FetchType.LAZY)
    val seasons: List<Seasons>,
    val animeStatus: AnimeStatus
)

