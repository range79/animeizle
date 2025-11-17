package com.range.rangeWatch.user.api

import com.range.rangeWatch.user.dto.response.UserResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("\${api.prefix}/users")
interface UserApi {

    @GetMapping("/me")
    fun me(): UserResponse

//    @GetMapping("/{id}")
//    fun getUserWithId(@PathVariable id: UUID): UserResponse

    @DeleteMapping("/me")
    fun deleteAccount()
}
