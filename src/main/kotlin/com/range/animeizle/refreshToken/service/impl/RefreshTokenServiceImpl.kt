package com.range.animeizle.refreshToken.service.impl

import com.range.animeizle.refreshToken.domain.entity.RefreshToken
import com.range.animeizle.refreshToken.exception.UnTrustedDeviceException
import com.range.animeizle.refreshToken.service.RefreshTokenService
import com.range.animeizle.common.util.DeviceInfoHolder
import com.range.animeizle.refreshToken.domain.repository.RefreshTokenRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class RefreshTokenServiceImpl(
    private val accessTokenRepository: RefreshTokenRepository
) : RefreshTokenService {

    override fun generateToken(userId: UUID): String {
        val context = DeviceInfoHolder.getContext()
            ?: throw IllegalStateException("Device information not found in context")

        val deviceName = context.deviceName ?: "unknown"

        accessTokenRepository.deleteByUserIdAndDevice(userId, deviceName)

        val token = RefreshToken.createForUser(userId, deviceName)
        accessTokenRepository.save(token)

        return token.id
    }

    override fun deleteToken(token: String) {
        if (accessTokenRepository.existsById(token)) {
            accessTokenRepository.deleteById(token)
        }
    }

    override fun deleteTokenByUserIdAndDeviceId(userId: UUID, device: String) {
        accessTokenRepository.deleteByUserIdAndDevice(userId, device)
    }

    override fun rotateToken(token: String): String {
        val oldToken = accessTokenRepository.findById(token)
            .orElseThrow { IllegalArgumentException("Refresh token not found") }
        val context = DeviceInfoHolder.getContext()
            ?: throw IllegalStateException("Device information not found in context")

        val deviceName = context.deviceName ?: "unknown"
        if (oldToken.device!=deviceName){
            accessTokenRepository.delete(oldToken)
        throw UnTrustedDeviceException("Device Untrusted please reLogin")
        }

        accessTokenRepository.delete(oldToken)

        val newToken = RefreshToken.createForUser(oldToken.userId, oldToken.device)
        accessTokenRepository.save(newToken)

        return newToken.id
    }
}
