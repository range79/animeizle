package com.range.rangeWatch.user.service

import com.range.rangeWatch.user.domain.entity.User
import com.range.rangeWatch.user.domain.entity.UserProfile
import com.range.rangeWatch.user.dto.request.UserProfileRequest
import com.range.rangeWatch.user.dto.response.UserProfileResponse
import org.springframework.web.multipart.MultipartFile


interface UserProfileService {
    fun create(user: User,request: UserProfileRequest)
    fun update(updatedUserProfile: UserProfile)
    fun findByUsername(username: String): UserProfileResponse
    fun me(): UserProfileResponse
    fun addProfilePicture(multipartFile: MultipartFile)
    fun removeProfilePicture()
}