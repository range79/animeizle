package com.range.rangeWatch.userprofile.controller

import com.range.rangeWatch.userprofile.api.UserProfileCommandApi
import com.range.rangeWatch.userprofile.domain.entity.UserProfile
import com.range.rangeWatch.userprofile.dto.response.UserProfileResponse
import com.range.rangeWatch.userprofile.service.UserProfileCommandService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class UserProfileCommandController (
    private val userProfileService: UserProfileCommandService
): UserProfileCommandApi {
    override fun update(updatedUserProfile: UserProfile) {
        return userProfileService.update(updatedUserProfile)
    }

    override fun addProfilePicture(multipartFile: MultipartFile) {
        return userProfileService.addProfilePicture(multipartFile)
    }

    override fun removeProfilePicture() {
        return userProfileService.removeProfilePicture()
    }

}