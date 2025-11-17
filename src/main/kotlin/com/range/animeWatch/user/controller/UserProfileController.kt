package com.range.animeWatch.user.controller

import com.range.animeWatch.user.api.UserProfileApi
import com.range.animeWatch.user.domain.entity.UserProfile
import com.range.animeWatch.user.dto.response.UserProfileResponse
import com.range.animeWatch.user.service.UserProfileService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class UserProfileController (
    private val userProfileService: UserProfileService
): UserProfileApi{
    override fun update(updatedUserProfile: UserProfile) {
        return userProfileService.update(updatedUserProfile)
    }

    override fun findByUsername(username: String): UserProfileResponse {
        return userProfileService.findByUsername(username)
    }

    override fun me(): UserProfileResponse {
        return userProfileService.me()
    }

    override fun addProfilePicture(multipartFile: MultipartFile) {
        return userProfileService.addProfilePicture(multipartFile)
    }

    override fun removeProfilePicture() {
        return userProfileService.removeProfilePicture()
    }


}