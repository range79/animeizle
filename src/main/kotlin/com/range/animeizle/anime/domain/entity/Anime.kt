package com.range.animeizle.anime.domain.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID
@Entity
@Table(name = "anime")
data class Anime(
    @Id
    val id: UUID = UUID.randomUUID(),

    var title: String = "",
    var description: String = "",
    var imageUrl: String = "",

    @OneToMany(mappedBy = "anime", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var seasons: MutableList<Season> = mutableListOf()
)
