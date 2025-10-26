package com.range.userprofileservice.service.impl

import com.range.userprofileservice.domain.entity.UserProfile
import com.range.userprofileservice.domain.repository.UserProfileRepository
import com.range.userprofileservice.dto.UserProfileRequest
import com.range.userprofileservice.dto.UserShortProfileResponse
import com.range.userprofileservice.exception.UserNotExitsException
import com.range.userprofileservice.exception.UserProfileNotFound
import com.range.userprofileservice.service.ProfilePhotoService
import com.range.userprofileservice.service.UserProfileService
import com.range.userprofileservice.service.UserService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Service
class UserProfileServiceImpl(
    private val userProfileRepository: UserProfileRepository,
    private val profilePhotoService: ProfilePhotoService,
    private val userService: UserService
) : UserProfileService {

    private val ALLOWED_EXTENSIONS = listOf("jpg", "jpeg", "png")

    override fun saveProfile(
        userId: UUID,
        multipartFile: MultipartFile,
        userProfileRequest: UserProfileRequest
    ) {
        if (!userService.userExits(userId)) {
            throw UserNotExitsException("User does not exist.")
        }
        val originalFilename = multipartFile.originalFilename ?: "file"
        val extension = originalFilename.substringAfterLast('.', "").lowercase()
        if (extension !in ALLOWED_EXTENSIONS) {
            throw IllegalArgumentException("Unsupported file type: .$extension")
        }

        val filename = "${userId}-${System.currentTimeMillis()}.$extension"
        val profileUrl = profilePhotoService.uploadPhoto(multipartFile, filename)
        val userProfile = UserProfile(
            id = userId,
            description = userProfileRequest.description,
            profileUrl = profileUrl
        )

        userProfileRepository.save(userProfile)
    }

    override fun getShortUserProfile(userId: UUID): UserShortProfileResponse {
        val user = userProfileRepository.findById(userId).orElseThrow {
            UserProfileNotFound("User Not Found")
        }
        return UserShortProfileResponse(user.id, user.profileUrl)
    }

    override fun getUserFullProfile(user: UUID): UserProfile {
        return userProfileRepository.findById(user).orElseThrow {
            UserProfileNotFound("User Not Found")
        }
    }

    override fun deleteProfile(userid: UUID) {
        if (!userService.userExits(userid)) {
            throw UserNotExitsException("User Not Exists")
        }

        val profile = userProfileRepository.findById(userid).orElseThrow {
            UserProfileNotFound("Profile Not Found")
        }

        profilePhotoService.deletePhoto(profile.profileUrl.substringAfterLast("/"))
        userProfileRepository.deleteById(userid)
    }


}
