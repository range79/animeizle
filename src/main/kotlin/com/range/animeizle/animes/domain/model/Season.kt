package com.range.animeizle.animes.domain.model


import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Table(name = "seasons")
@Entity
data class Season(
    @Id val id: Long,
    val seasonNumber: Int,
    @ManyToOne
    @JoinColumn(name = "anime_id")
    val anime: Anime,
    @OneToMany(mappedBy = "season")
    val episodes: List<Episode>
)


