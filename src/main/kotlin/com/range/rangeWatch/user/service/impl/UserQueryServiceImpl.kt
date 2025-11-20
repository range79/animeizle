package com.range.rangeWatch.user.service.impl

import com.range.rangeWatch.user.exception.UserNotFoundException
import com.range.rangeWatch.common.util.SecurityContextUtil
import com.range.rangeWatch.user.domain.entity.User
import com.range.rangeWatch.user.domain.repository.UserRepository
import com.range.rangeWatch.user.service.UserQueryService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserQueryServiceImpl(private val securityContextUtil: SecurityContextUtil,
                           private val userRepository: UserRepository
) : UserQueryService {
    override fun me(): User {
        val id = securityContextUtil.getCurrentUserId()
        return  userRepository.findById(id).orElseThrow { UserNotFoundException("User Not found") }

    }

    override fun getUser(id: UUID): User {
        return userRepository.findById(id)
            .orElseThrow { UserNotFoundException("User not found") }

    }

    override fun getUserWithEmail(email: String): User {

        return userRepository.findByEmail(email)
            .orElseThrow { UserNotFoundException("User not found") }
    }
}