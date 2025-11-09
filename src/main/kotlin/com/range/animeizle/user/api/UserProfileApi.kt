package com.range.animeizle.user.api

import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.domain.entity.UserProfile
import com.range.animeizle.user.dto.request.UserProfileRequest
import com.range.animeizle.user.dto.response.UserProfileResponse
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RequestMapping("\${api.prefix}/userprofile")
interface UserProfileApi {
    @PutMapping("/update")
    fun update(@RequestBody updatedUserProfile: UserProfile)

    @GetMapping("/username/{username}")
    fun findByUsername(@PathVariable username: String): UserProfileResponse

    @GetMapping("/me")
    fun me(): UserProfileResponse

    @PostMapping("/picture")
    fun addProfilePicture(@RequestParam("file") multipartFile: MultipartFile)

    @DeleteMapping("/picture")
    fun removeProfilePicture()
}
