package com.ougi.callme.domain.usecase

import com.ougi.callme.domain.repository.MessagingUsersRepository

interface GetUserTokenUseCase {

    suspend fun getToken(login: String): String?
}

class GetUserTokenUseCaseImpl(
    private val messagingUsersRepository: MessagingUsersRepository
) : GetUserTokenUseCase {

    override suspend fun getToken(login: String) =
        messagingUsersRepository.getTokenByLogin(login)

}