package com.range.userprofileservice.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import java.util.UUID

@FeignClient("user-service")
interface UserService {
    @GetMapping("/{id}")
    fun userExits(userId: UUID): Boolean
}
