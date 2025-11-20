package com.range.rangeWatch.user.domain.entity

import com.range.rangeWatch.user.domain.enums.Role
import com.range.rangeWatch.user.dto.request.RegisterRequest
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction
import java.util.UUID

@Table(name = "users")
@Entity
@SQLRestriction("deleted = false")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID=UUID.randomUUID(),
    @Column(nullable = false)
    var username: String,
    var password: String,
    @Column(unique = true, nullable = false)
    var email: String,
    var twoFactorEnabled: Boolean = false,
    var role: Role = Role.USER,
    var deleted: Boolean = false,
){
    companion object{
        fun generateUser(registerRequest: RegisterRequest, hashedPassword: String): User {
            return User(
                username = registerRequest.username,
                password = hashedPassword,
                email = registerRequest.email,
                twoFactorEnabled = false,
                role = Role.USER
                )
        }
    }
}