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
    var id: Long? = null,
    var username: String,
    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    var userid: User,
    var profileImageUrl: String?,
    var favoriteanimes: List<String>?,
    var comments: String? ,
    var likes: String?,
)