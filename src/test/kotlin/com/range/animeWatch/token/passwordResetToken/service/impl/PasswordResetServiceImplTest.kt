package com.range.animeWatch.token.passwordResetToken.service.impl

import com.range.animeWatch.token.passwordResetToken.domain.entity.PasswordResetToken
import com.range.animeWatch.token.passwordResetToken.domain.repository.PasswordResetTokenRepository
import com.range.animeWatch.token.passwordResetToken.exception.PasswordTokenIsNotValidException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.Optional
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class PasswordResetServiceImplTest {

    @Mock
    private lateinit var passwordResetTokenRepository: PasswordResetTokenRepository

    @InjectMocks
    private lateinit var passwordResetTokenServiceImpl: PasswordResetTokenServiceImpl

    private val email = "test@gmail.com"

    @Test

    fun `getEmailFromToken should return email when token exists`() {
        val token = PasswordResetToken.createForUser(email)
        `when`(passwordResetTokenRepository.findById(token.id)).thenReturn(Optional.of(token))

        val result = passwordResetTokenServiceImpl.getEmailFromToken(token.id)

        assertEquals(email, result)
        verify(passwordResetTokenRepository, times(1)).findById(token.id)
    }

    @Test
    fun `getEmailFromToken should throw exception when token does not exist`() {
        `when`(passwordResetTokenRepository.findById("nonexistent")).thenReturn(Optional.empty())

        assertThrows<PasswordTokenIsNotValidException> {
            passwordResetTokenServiceImpl.getEmailFromToken("nonexistent")
        }
    }


    @Test
    fun `generateToken should delete old token if exists`() {

        `when`(passwordResetTokenRepository.existsByEmail(email)).thenReturn(true)
        val tokenId = passwordResetTokenServiceImpl.generateToken(email)
        verify(passwordResetTokenRepository, times(1)).existsByEmail(email)
        verify(passwordResetTokenRepository, times(1)).deleteByEmail(email)
        verify(passwordResetTokenRepository, times(1)).save(any(PasswordResetToken::class.java))
        assertNotNull(tokenId)
    }
}
