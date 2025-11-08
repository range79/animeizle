package com.range.animeizle.user.service.impl

import com.range.animeizle.common.exception.UserNotFoundException
import com.range.animeizle.common.util.SecurityContextUtil
import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.dto.response.UserResponse
import com.range.animeizle.user.service.UserService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val securityContextUtil: SecurityContextUtil
) :
    UserService {
    override fun me() : UserResponse{

        val id = securityContextUtil.getCurrentUserId()
        val user = userRepository.findById(id).orElseThrow { UserNotFoundException("User Not found") }
        return user.toUSerResponse()
    }

    override fun getUser(id: UUID) : UserResponse{
        return userRepository.findById(id)
            .orElseThrow { UserNotFoundException("User not found") }
            .toUSerResponse()
    }

    override fun delete() {
        TODO("Not yet implemented")
    }

    private fun User.toUSerResponse(): UserResponse {
        return UserResponse(
            id = this.id,
            username = this.username,
        )
    }
}