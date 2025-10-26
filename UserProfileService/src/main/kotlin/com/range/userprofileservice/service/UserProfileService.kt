package com.range.userprofileservice.service

import com.range.userprofileservice.domain.entity.UserProfile
import com.range.userprofileservice.dto.UserProfileRequest
import com.range.userprofileservice.dto.UserShortProfileResponse
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

interface UserProfileService {
    fun saveProfile(userId: UUID,multipartFile: MultipartFile,userProfileRequest: UserProfileRequest)
    fun getShortUserProfile(userId: UUID): UserShortProfileResponse
    fun getUserFullProfile(user: UUID): UserProfile
    fun deleteProfile(userid: UUID)
}