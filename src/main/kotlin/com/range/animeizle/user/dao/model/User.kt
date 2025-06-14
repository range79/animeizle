package com.range.animeizle.user.dao.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "users")
@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
    var username: String,
    var password: String,
    var email: String,
    @Enumerated(EnumType.STRING)
    var role: Role,
)
