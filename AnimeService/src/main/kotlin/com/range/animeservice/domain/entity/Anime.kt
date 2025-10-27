package com.range.animeservice.domain.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "anime")
data class Anime(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    var title: String = "",
    var description: String = "",

    @OneToMany(mappedBy = "anime", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var seasons: MutableList<Season> = mutableListOf()
)
