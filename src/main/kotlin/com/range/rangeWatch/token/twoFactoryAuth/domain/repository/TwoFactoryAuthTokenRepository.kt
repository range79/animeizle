package com.range.rangeWatch.token.twoFactoryAuth.domain.repository

import com.range.rangeWatch.token.twoFactoryAuth.domain.entity.TwoFactoryAuthToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TwoFactoryAuthTokenRepository : CrudRepository<TwoFactoryAuthToken, UUID> {
    fun findByEmail(email: String): Optional<TwoFactoryAuthToken>
    fun existsPasswordResetTokenByEmail(email: String): Boolean
    fun deleteByEmail(email: String)
}