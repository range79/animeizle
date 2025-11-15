package com.range.animeizle.user.service

interface UserAccountService {

    fun sendActivationToUser(email: String)
    fun activateUser(email: String)
    fun frozeAccount(email: String)
    fun delete()

}