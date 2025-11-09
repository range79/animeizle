package com.range.animeizle.user.api

import com.range.animeizle.user.dto.response.UserResponse
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RequestMapping("\${api.prefix}/users")
interface UserApi {

    @GetMapping("/me")
    fun me(): UserResponse

    @GetMapping("/{id}")
    fun getUserWithId(@PathVariable id: UUID): UserResponse

    @DeleteMapping("/me")
    fun deleteAccount()
}
