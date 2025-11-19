package com.range.rangeWatch.user.service.impl

import com.range.rangeWatch.user.domain.repository.UserRepository
import com.range.rangeWatch.user.service.UserAccountService
import com.range.rangeWatch.user.service.UserQueryService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserAccountServiceImpl(
    private val userRepository: UserRepository,
    private val userQueryService: UserQueryService
) : UserAccountService {


    override fun activateUser(email: String) {
        val user = userRepository.findDeletedUserByEmail(email).orElseThrow { UsernameNotFoundException("User not found") }
        user.deleted = false
        userRepository.save(user)

    }

    override fun delete() {
        val  user =userQueryService.me()
        user.deleted = true
        userRepository.save(user)
    }

}