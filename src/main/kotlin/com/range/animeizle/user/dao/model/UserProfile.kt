package com.range.animeizle.user.dao.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Table(name = "user_profile")
@Entity
data class UserProfile(
    @Id
    var id: String? = null,
    var username: String? = null,
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    var userid: User? =null,
    var profileImageUrl: String? = null,
    var favoriteanimes: List<String>? = null,
    var comments: String? = null,
    var likes: String? = null,
)