package com.range.animeizle.token.domain.entity

import com.range.animeizle.user.domain.entity.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime


@Entity
@Table(name = "refresh_tokens")
data class RefreshToken (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true, length =  500)
    val token: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User? = null,

    @Column(nullable = false)
    val createdAt: LocalDateTime? = null,

    @Column(nullable = false)
    var expiresAt: LocalDateTime? = null,

    @Column(nullable = false)
    var revoked: Boolean = false
)
