package com.range.animeizle.user.service

interface UserAccountService {
    fun activateUser(email: String)
    fun frozeAccount(email: String)
    fun delete()
}