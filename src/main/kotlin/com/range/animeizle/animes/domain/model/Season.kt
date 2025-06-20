package com.range.animeizle.animes.domain.model


import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Table(name = "seasons")
@Entity
data class Season(
    @Id
    val id: Long,

    val seasonNumber: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anime_id")
    var anime: Anime? = null,

    @OneToMany(mappedBy = "season", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val episodes: MutableList<Episode> = mutableListOf()
)


