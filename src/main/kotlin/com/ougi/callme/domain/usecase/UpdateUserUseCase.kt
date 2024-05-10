package com.ougi.callme.domain.usecase

import com.ougi.callme.domain.repository.MessagingUsersRepository

interface UpdateUserUseCase {

    suspend fun update(
        login: String,
        newToken: String,
    )
}

class UpdateUserUseCaseImpl(
    private val messagingUsersRepository: MessagingUsersRepository
) : UpdateUserUseCase {


    override suspend fun update(
        login: String,
        newToken: String,
    ) =
        messagingUsersRepository.update(
            login = login,
            newFirebaseToken = newToken,
        )


}