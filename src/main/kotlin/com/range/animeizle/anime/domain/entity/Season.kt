package com.range.animeizle.anime.domain.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "season")
data class Season(
    @Id
    var id: UUID = UUID.randomUUID(),

    var title: String = "",
    var description: String = "",
    var imageUrl: String = "",

    @ManyToOne
    @JoinColumn(name = "anime_id")
    var anime: Anime? = null,

    @OneToMany(mappedBy = "season", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var episodes: MutableList<Episode> = mutableListOf()
)

