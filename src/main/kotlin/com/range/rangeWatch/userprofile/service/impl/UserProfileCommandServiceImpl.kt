package com.range.rangeWatch.userprofile.service.impl

import com.range.rangeWatch.user.exception.UserNotFoundException
import com.range.rangeWatch.userprofile.exception.UserProfileNotFoundException
import com.range.rangeWatch.common.service.PhotoService
import com.range.rangeWatch.common.util.SecurityContextUtil
import com.range.rangeWatch.user.domain.entity.User
import com.range.rangeWatch.userprofile.domain.entity.UserProfile
import com.range.rangeWatch.userprofile.domain.repository.UserProfileRepository
import com.range.rangeWatch.userprofile.dto.request.UpdateUserProfileRequest
import com.range.rangeWatch.userprofile.dto.request.UserProfileRequest
import com.range.rangeWatch.userprofile.service.UserProfileCommandService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@Service
class UserProfileCommandServiceImpl(
    private val userProfileRepository: UserProfileRepository,
    private val securityContextUtil: SecurityContextUtil,
    private val awsService: PhotoService
) : UserProfileCommandService {

    override fun create(user: User, request: UserProfileRequest) {
        val userProfile = UserProfile.create(user, request)
        userProfileRepository.save(userProfile)
    }

    override fun update(updatedUserProfile: UpdateUserProfileRequest) {
        val userId = securityContextUtil.getCurrentUserId()
        val existingProfile = userProfileRepository.findById(userId)
            .orElseThrow { UserProfileNotFoundException("User profile not found") }
        existingProfile.apply {
            birthDate = updatedUserProfile.birthDate
            gender = updatedUserProfile.gender
            bio = updatedUserProfile.bio
        }
        userProfileRepository.save(existingProfile)
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