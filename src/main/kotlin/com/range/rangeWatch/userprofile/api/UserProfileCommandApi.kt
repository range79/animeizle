package com.range.rangeWatch.userprofile.api

import com.range.rangeWatch.userprofile.domain.entity.UserProfile
import com.range.rangeWatch.userprofile.dto.response.UserProfileResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

@RequestMapping("\${api.prefix}/user-profile")
interface UserProfileCommandApi {
    @PutMapping("/update")
    fun update(@RequestBody updatedUserProfile: UserProfile)

    @PostMapping("/picture")
    fun addProfilePicture(@RequestParam("file") multipartFile: MultipartFile)

    @DeleteMapping("/picture")
    fun removeProfilePicture()
}