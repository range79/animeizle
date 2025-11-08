package com.range.animeizle.user.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.util.UUID
@Table(name = "user_profile")
@Entity
data class UserProfile(
    @Id
    val id: UUID,

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    var user: User,

    var bio: String?,
    var avatarUrl: String?
)