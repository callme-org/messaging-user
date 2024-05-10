package com.ougi.callme.domain.repository

import com.ougi.callme.data.model.dto.CreateUserDto

interface MessagingUsersRepository {

    suspend fun createOrUpdate(user: CreateUserDto)

    suspend fun update(
        login: String,
        newFirebaseToken: String
    )

    suspend fun getTokenByLogin(login: String): String?
}