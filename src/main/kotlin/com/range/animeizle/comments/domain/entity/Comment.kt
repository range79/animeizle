package com.range.animeizle.comments.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "comments")
@Entity
data class Comment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val comment: String,
    val rating: Int,
    val animeId: Int,
    val episodeId: Int,
    val userId: Int,
    val createdAt: String,
    val updatedAt: String
)