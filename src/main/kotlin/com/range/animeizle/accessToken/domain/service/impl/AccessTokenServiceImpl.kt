package com.range.animeizle.accessToken.domain.service.impl

import com.range.animeizle.accessToken.domain.entity.AccessToken
import com.range.animeizle.accessToken.domain.repository.AccessTokenRepository
import com.range.animeizle.accessToken.domain.service.AccessTokenService
import com.range.animeizle.common.util.DeviceInfoHolder
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccessTokenServiceImpl(
    private val accessTokenRepository: AccessTokenRepository
) : AccessTokenService {

    override fun generateToken(userId: UUID): String {
        val context = DeviceInfoHolder.getContext()
            ?: throw IllegalStateException("Device information not found in context")

        val deviceName = context.deviceName ?: "unknown"

        // Aynı cihaz için eski token varsa sil (çakışmayı önler)
        accessTokenRepository.deleteByUserIdAndDevice(userId, deviceName)

        val token = AccessToken.Companion.createForUser(userId, deviceName, )
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
            .orElseThrow { IllegalArgumentException("Access token not found") }
        val context = DeviceInfoHolder.getContext()
            ?: throw IllegalStateException("Device information not found in context")

        val deviceName = context.deviceName ?: "unknown"
        if (oldToken.device!=deviceName){

        }

        accessTokenRepository.delete(oldToken)

        val newToken = AccessToken.Companion.createForUser(oldToken.userId, oldToken.device)
        accessTokenRepository.save(newToken)

        return newToken.id
    }
}
