package com.range.animeizle.animes.dao.model

import com.range.animeizle.animes.enums.AnimeStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "animes")
data class Animes (
    @Id
    @GeneratedValue
    var id: Long? = null,
    val title: String,
    val description: String?,
    val type: String,
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    val animeStatus: AnimeStatus
)