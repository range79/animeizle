package com.range.animeizle.user.domain.entity

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


    var comments: String? ,
    var profileImg: ByteArray
)