package com.range.animeWatch.user.api

import com.range.animeWatch.user.dto.response.UserResponse
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
