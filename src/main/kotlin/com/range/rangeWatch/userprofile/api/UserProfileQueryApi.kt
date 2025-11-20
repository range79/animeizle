package com.range.rangeWatch.userprofile.api

import com.range.rangeWatch.userprofile.dto.response.UserProfileResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping(value = ["\${api.prefix}/user-profiles"])
interface UserProfileQueryApi {

    @GetMapping("/{username}")
    fun findByUsername(@PathVariable username: String): UserProfileResponse

    @GetMapping("/me")
    fun me(): UserProfileResponse

}