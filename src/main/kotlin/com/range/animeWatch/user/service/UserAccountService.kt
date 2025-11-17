package com.range.animeWatch.user.service

interface UserAccountService {
    fun activateUser(email: String)
    fun frozeAccount(email: String)
    fun delete()
}