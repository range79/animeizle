package com.range.animeWatch.user.service.impl

import com.range.animeWatch.common.exception.UserNotFoundException
import com.range.animeWatch.common.exception.UserProfileNotFoundException
import com.range.animeWatch.common.service.AmazonService
import com.range.animeWatch.common.util.SecurityContextUtil
import com.range.animeWatch.user.domain.entity.User
import com.range.animeWatch.user.domain.entity.UserProfile
import com.range.animeWatch.user.domain.repository.UserProfileRepository
import com.range.animeWatch.user.dto.request.UserProfileRequest
import com.range.animeWatch.user.dto.response.UserProfileResponse
import com.range.animeWatch.user.service.UserProfileService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Service
class UserProfileServiceImpl(
    private val userProfileRepository: UserProfileRepository,
    private val securityContextUtil: SecurityContextUtil,
    private val awsService : AmazonService
) : UserProfileService {

    override fun create(user: User, request: UserProfileRequest) {
        val userProfile = UserProfile.create(user, request)
        userProfileRepository.save(userProfile)
    }

    override fun update(updatedUserProfile: UserProfile) {
        val userId = securityContextUtil.getCurrentUserId()
        val existingProfile = userProfileRepository.findById(userId)
            .orElseThrow { UserProfileNotFoundException("User profile not found") }
        userProfileRepository.save(existingProfile)
    }

    override fun findByUsername(username: String): UserProfileResponse {
        val profile = userProfileRepository.findByUserUsername(username)
            .orElseThrow { UserProfileNotFoundException("User profile not found for username: $username") }

        return UserProfileResponse.fromEntity(profile)
    }

    override fun me(): UserProfileResponse {
        val userId = securityContextUtil.getCurrentUserId()
        val profile = userProfileRepository.findById(userId)
            .orElseThrow { UserProfileNotFoundException("User profile not found for current user") }
        return UserProfileResponse.fromEntity(profile)
    }

    override fun addProfilePicture(multipartFile: MultipartFile) {
        val userId = securityContextUtil.getCurrentUserId()
        val profile = userProfileRepository.findById(userId)
            .orElseThrow { UserNotFoundException("User profile not found") }
        profile.avatarUrl?.let { oldUrl ->
            val oldFileName = oldUrl.substringAfterLast("/")
            awsService.deletePhoto("profile-pictures-bucket", oldFileName)
        }

        val fileExtension = multipartFile.originalFilename?.substringAfterLast('.', "") ?: "jpg"
        val newFileName = "$userId-${UUID.randomUUID()}.$fileExtension"
        val uploadedUrl = awsService.addPhoto("profile-pictures-bucket", multipartFile, newFileName)

        profile.avatarUrl = uploadedUrl
        userProfileRepository.save(profile)
    }

    override fun removeProfilePicture() {
        val userId = securityContextUtil.getCurrentUserId()
        val profile = userProfileRepository.findById(userId)
            .orElseThrow { UserProfileNotFoundException("User profile not found") }

        profile.avatarUrl?.let { oldUrl ->
            val oldFileName = oldUrl.substringAfterLast("/")
            awsService.deletePhoto("profile-pictures-bucket", oldFileName)
        }

        profile.avatarUrl = null
        userProfileRepository.save(profile)
    }


}
