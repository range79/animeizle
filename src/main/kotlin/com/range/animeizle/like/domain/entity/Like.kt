package com.range.animeizle.like.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "like_episodes")
@Entity
data class Like (
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null,

    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Column(name = "episode_id", nullable = false)
    val episodeId: Long,

    val likedAt: LocalDateTime = LocalDateTime.now()
)