package com.range.animeizle.user.api

import com.range.animeizle.user.dto.response.UserResponse
import org.springframework.web.bind.annotation.RequestMapping
import java.util.UUID

@RequestMapping("\${api.prefix}/")
interface UserApi {
    fun me(): UserResponse
    fun getUserWithId(id: UUID): UserResponse
    fun deleteAccount()
    //TODO i'll add more
}