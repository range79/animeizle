package com.range.animeizle.user.service

import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.domain.entity.UserProfile
import com.range.animeizle.user.dto.request.UserProfileRequest
import com.range.animeizle.user.dto.response.UserProfileResponse
import org.springframework.web.multipart.MultipartFile
import java.util.*


interface UserProfileService {
    fun create(user: User,request: UserProfileRequest)
    fun update(updatedUserProfile: UserProfile)
    fun findByUsername(username: String): UserProfileResponse
    fun me(): UserProfileResponse
    fun addProfilePicture(multipartFile: MultipartFile)
    fun removeProfilePicture()
}