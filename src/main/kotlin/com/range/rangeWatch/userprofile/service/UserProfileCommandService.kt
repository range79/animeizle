package com.range.rangeWatch.userprofile.service

import com.range.rangeWatch.user.domain.entity.User
import com.range.rangeWatch.userprofile.domain.entity.UserProfile
import com.range.rangeWatch.userprofile.dto.request.UserProfileRequest
import org.springframework.web.multipart.MultipartFile

interface UserProfileCommandService {
    fun create(user: User, request: UserProfileRequest)
    fun update(updatedUserProfile: UserProfile)
    fun addProfilePicture(multipartFile: MultipartFile)
    fun removeProfilePicture()
}