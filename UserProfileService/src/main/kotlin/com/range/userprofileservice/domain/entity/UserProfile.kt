package com.range.userprofileservice.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID
@Entity
@Table(name = "UserProfile")
data class UserProfile(
    @Id
    @Column(unique = true, nullable = false)
    val id: UUID,
    val profileUrl: String,
    val description: String?,
    )