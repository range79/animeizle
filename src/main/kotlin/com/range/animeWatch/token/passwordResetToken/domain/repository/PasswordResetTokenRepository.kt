package com.range.animeWatch.token.passwordResetToken.domain.repository

import com.range.animeWatch.token.passwordResetToken.domain.entity.PasswordResetToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PasswordResetTokenRepository : CrudRepository<PasswordResetToken, String> {
    fun deleteByEmail(email: String)
    fun existsByEmail(email: String): Boolean
}