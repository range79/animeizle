package com.range.animeizle.animes.domain.entity


import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Table(name = "seasons")
@Entity
data class Season(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val seasonSize: Int,
    val seasonNumber: Int,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anime_id")
    var anime: Anime? = null,

    @OneToMany(mappedBy = "season", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val episodes: MutableList<Episode> = mutableListOf()
)


