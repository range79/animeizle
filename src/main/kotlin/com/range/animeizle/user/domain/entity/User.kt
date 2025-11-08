package com.range.animeizle.user.domain.entity

import com.range.animeizle.user.dto.request.RegisterRequest
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Table(name = "user")
@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID=UUID.randomUUID(),
    var username: String,
    var password: String,
    var email: String,
    var twoFactorEnabled: Boolean = false,
    var role: Role? = Role.USER,
){
    companion object{
        fun generateUser(registerRequest: RegisterRequest,password: String): User {
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