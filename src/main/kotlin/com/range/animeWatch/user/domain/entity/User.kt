package com.range.animeWatch.user.domain.entity

import com.range.animeWatch.user.domain.enums.Role
import com.range.animeWatch.user.dto.request.RegisterRequest
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
    var username: String,
    var password: String,
    var email: String,
    var twoFactorEnabled: Boolean = false,
    var role: Role? = Role.USER,
    var deleted: Boolean = false,
){
    companion object{
        fun generateUser(registerRequest: RegisterRequest, hashedPassword: String): User {
            return User(
                username = registerRequest.username,
                password = registerRequest.password,
                email = registerRequest.email,
                twoFactorEnabled = false,
                role = Role.USER
                )
        }
    }
}