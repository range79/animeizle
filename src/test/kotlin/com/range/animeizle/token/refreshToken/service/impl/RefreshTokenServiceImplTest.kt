package com.range.animeizle.token.refreshToken.service.impl

import com.range.animeizle.common.util.DeviceInfoHolder
import com.range.animeizle.common.util.RequestContext
import com.range.animeizle.token.refreshToken.domain.entity.RefreshToken
import com.range.animeizle.token.refreshToken.domain.repository.RefreshTokenRepository
import com.range.animeizle.token.refreshToken.exception.UnTrustedDeviceException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class RefreshTokenServiceImplTest {

    @Mock
    private lateinit var refreshTokenRepository: RefreshTokenRepository

    @InjectMocks
    private lateinit var refreshTokenServiceImpl: RefreshTokenServiceImpl

    private val userId = UUID.randomUUID()

    @Suppress("UNCHECKED_CAST")
    private fun <T> anySafe(): T {
        any<T>()
        return null as T
    }

    @BeforeEach
    fun setUp() {
        DeviceInfoHolder.setContext(RequestContext(ip = "127.0.0.1", deviceName = "TestDevice"))
    }

    @Test

    fun `generateToken should delete old token and save new one`() {

        doNothing().`when`(refreshTokenRepository)
            .deleteByUserIdAndDevice(anySafe(), anyString())

        val savedToken = RefreshToken.createForUser(userId, "TestDevice")
        `when`(refreshTokenRepository.save(anySafe())).thenReturn(savedToken)

        val tokenId = refreshTokenServiceImpl.generateToken(userId)

        verify(refreshTokenRepository).deleteByUserIdAndDevice(userId, "TestDevice")
        verify(refreshTokenRepository).save(anySafe())
        assertNotNull(tokenId)
        assertNotEquals("", tokenId)
    }

    @Test
    fun `deleteToken should remove token if exists`() {
        val token = "token123"
        `when`(refreshTokenRepository.existsById(token)).thenReturn(true)

        refreshTokenServiceImpl.deleteToken(token)

        verify(refreshTokenRepository, times(1)).deleteById(token)
    }

    @Test
    fun `deleteToken should not delete if token not found`() {
        val token = "notFound"
        `when`(refreshTokenRepository.existsById(token)).thenReturn(false)

        refreshTokenServiceImpl.deleteToken(token)

        verify(refreshTokenRepository, never()).deleteById(anyString())
    }

    @Test
    fun `deleteTokenByUserIdAndDeviceId should call repository`() {
        refreshTokenServiceImpl.deleteTokenByUserIdAndDeviceId(userId, "TestDevice")

        verify(refreshTokenRepository, times(1))
            .deleteByUserIdAndDevice(userId, "TestDevice")
    }

    @Test
    fun `rotateToken should replace old token with new one if device trusted`() {
        val oldToken = RefreshToken.createForUser(userId, "TestDevice")
        `when`(refreshTokenRepository.findById(oldToken.id)).thenReturn(Optional.of(oldToken))

        val newToken = RefreshToken.createForUser(userId, "TestDevice")
        `when`(refreshTokenRepository.save(anySafe())).thenReturn(newToken)

        val rotatedId = refreshTokenServiceImpl.rotateToken(oldToken.id)

        verify(refreshTokenRepository).delete(oldToken)
        verify(refreshTokenRepository).save(anySafe())
        assertNotNull(rotatedId)
        assertNotEquals(oldToken.id, rotatedId)
    }


    @Test
    fun `rotateToken should throw UnTrustedDeviceException if device mismatch`() {
        val oldToken = RefreshToken.createForUser(userId, "OldDevice")
        `when`(refreshTokenRepository.findById(oldToken.id)).thenReturn(Optional.of(oldToken))

        DeviceInfoHolder.setContext(RequestContext(ip = "127.0.0.1", deviceName = "AnotherDevice"))

        assertThrows(UnTrustedDeviceException::class.java) {
            refreshTokenServiceImpl.rotateToken(oldToken.id)
        }

        verify(refreshTokenRepository).delete(oldToken)
    }
}
