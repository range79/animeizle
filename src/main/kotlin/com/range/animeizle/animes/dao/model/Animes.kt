package com.range.animeizle.animes.dao.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "animes")
data class Animes (
    @Id
    @GeneratedValue
    var id: Long? = null,
    var title: String? = null,
    var description: String? = null,
    var type: String? = null,
    var url: String? = null
)