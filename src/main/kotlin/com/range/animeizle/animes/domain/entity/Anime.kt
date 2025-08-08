package com.range.animeizle.animes.domain.entity

import com.range.animeizle.animes.domain.enums.AnimeStatus
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "anime")
data class Anime(
    @Id
    val id: Long?,

    var title: String,

    var description: String,

    @Enumerated(EnumType.STRING)
    var animeStatus: AnimeStatus,
    @OneToMany(
        mappedBy = "anime",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    val seasons: MutableList<Season>? = mutableListOf()

)