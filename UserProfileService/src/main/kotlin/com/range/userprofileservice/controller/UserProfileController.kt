package com.range.userprofileservice.controller

import com.range.userprofileservice.domain.entity.UserProfile
import com.range.userprofileservice.dto.UserProfileRequest
import com.range.userprofileservice.dto.UserShortProfileResponse
import com.range.userprofileservice.service.UserProfileService
import feign.Headers
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RestController
@RequestMapping("/user-profile")
class UserProfileController(private val userProfileService: UserProfileService) {

    @GetMapping("/{userId}/short")
    fun getProfile(@PathVariable userId: UUID): UserShortProfileResponse {
        return userProfileService.getShortUserProfile(userId)
    }

    @PostMapping("/")
    fun postProfile(@RequestHeader("x-user-Id") userId: UUID,
        @RequestPart("file") multipartFile: MultipartFile,
        @RequestPart("data") userProfileRequest: UserProfileRequest
    ) {
        return userProfileService.saveProfile(multipartFile, userProfileRequest)
    }

    @DeleteMapping("/")
    fun deleteProfile(@RequestHeader("x-User-id") userid: UUID) {
        return userProfileService.deleteProfile(userid)
    }


}