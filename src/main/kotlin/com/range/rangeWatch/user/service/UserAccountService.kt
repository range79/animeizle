package com.range.rangeWatch.user.service

interface UserAccountService {
    fun activateUser(email: String)
    fun frozeAccount(email: String)
    fun delete()
}