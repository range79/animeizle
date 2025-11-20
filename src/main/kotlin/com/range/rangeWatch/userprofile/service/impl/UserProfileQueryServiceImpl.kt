package com.range.rangeWatch.userprofile.service.impl

import com.range.rangeWatch.common.util.SecurityContextUtil
import com.range.rangeWatch.userprofile.domain.entity.UserProfile
import com.range.rangeWatch.userprofile.domain.repository.UserProfileRepository
import com.range.rangeWatch.userprofile.dto.response.UserProfileResponse
import com.range.rangeWatch.userprofile.exception.UserProfileNotFoundException
import com.range.rangeWatch.userprofile.service.UserProfileQueryService
import org.springframework.stereotype.Service

@Service
class UserProfileQueryServiceImpl (
    private val userProfileRepository: UserProfileRepository,
    private val securityContextUtil: SecurityContextUtil,
): UserProfileQueryService {
    override fun findByUsername(username: String): UserProfile {
        return userProfileRepository.findByUserUsername(username)
            .orElseThrow { UserProfileNotFoundException("User profile not found for username: $username") }
    }

    override fun me(): UserProfile {
        val userId = securityContextUtil.getCurrentUserId()
        return userProfileRepository.findById(userId)
            .orElseThrow { UserProfileNotFoundException("User profile not found for current user") }

    }

}