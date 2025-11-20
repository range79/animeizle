package com.range.rangeWatch.userprofile.controller

import com.range.rangeWatch.userprofile.api.UserProfileQueryApi
import com.range.rangeWatch.userprofile.dto.response.UserProfileResponse
import com.range.rangeWatch.userprofile.mapper.UserProfileMapper
import com.range.rangeWatch.userprofile.service.UserProfileQueryService
import org.springframework.web.bind.annotation.RestController

@RestController
class UserProfileQueryController (
    private val userProfileQueryService: UserProfileQueryService
    private val userProfileMapper: UserProfileMapper
): UserProfileQueryApi {
    override fun findByUsername(username: String): UserProfileResponse {
        return userProfileMapper.toUserProfileResponse(userProfileQueryService.findByUsername(username))
    }

    override fun me(): UserProfileResponse {
        return userProfileMapper.toUserProfileResponse(userProfileQueryService.me())
    }
}