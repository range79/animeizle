package com.range.animeizle.like.domain.entity

import com.range.animeizle.animes.domain.entity.Episode
import com.range.animeizle.user.domain.entity.User
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime
@Table(name = "like_episodes")
@Entity
data class Like (
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "episode_id")
    val episode: Episode,

    val likedAt: LocalDateTime = LocalDateTime.now()
)